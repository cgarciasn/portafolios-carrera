package es.unex.trackstone10.ui.home.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import es.unex.trackstone10.API.*
import es.unex.trackstone10.CU03.CardInfoActivity
import es.unex.trackstone10.adapter.cardAdapter
import es.unex.trackstone10.databinding.FragmentCardsBinding
import kotlinx.coroutines.*

class CardsFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var binding: FragmentCardsBinding
    private lateinit var adapter: cardAdapter
    private val handler = Handler(Looper.getMainLooper())
    private var cardList = (mutableListOf<CardResponse>())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardsBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.svCard.setOnQueryTextListener(this)
        initRecyclerView()
        APIToken.getToken()
        getCardsRecycler()
        return view
    }

    private fun initRecyclerView() {
        adapter = cardAdapter(cardList) { onItemSelected(it) }
        binding.recyclerViewCards.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewCards.adapter = adapter
    }

    private fun onItemSelected(cards: CardResponse) {
        val intent: Intent = Intent(activity, CardInfoActivity::class.java)
        intent.putExtra("CARD_OBJ", cards)
        startActivity(intent)
    }


    private fun getCardsRecycler() {
        CoroutineScope(Dispatchers.IO).launch {
            delay(2000)
            val retrofit = APIToken.getRetrofit("/hearthstone/cards/")

            val call = retrofit.create(APIService::class.java)
                .getCards("standard", "groupByClass:asc,manaCost:asc", 1300, "en_US")

            val cards = call.body()
            handler.post {
                if (call.isSuccessful) {
                    if (cards != null) {
                        val cardsReceived = cards.cards
                        cardList.clear()
                        cardList.addAll(cardsReceived)
                        adapter.notifyDataSetChanged()
                    }
                } else {
                    showError()
                }
            }
        }
    }


    private fun searchByName(query: String) {
        CoroutineScope(Dispatchers.IO).launch {

            val retrofit = APIToken.getRetrofit("/hearthstone/cards/")

            val call =
                retrofit.create(APIService::class.java)
                    .getCardsByName(query, "standard", "groupByClass:asc,manaCost:asc",1300, "en_US")

            val cards = call.body()
            handler.post {
                if (call.isSuccessful) {
                    if (cards != null) {
                        val cardsReceived = cards.cards
                        cardList.clear()
                        cardList.addAll(cardsReceived)
                        adapter.notifyDataSetChanged()
                    }
                } else {
                    showError()
                }
                hideKeyboard()
            }
        }
    }

    private fun hideKeyboard() {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.Croot.windowToken, 0)
    }

    private fun showError() {
        Toast.makeText(activity, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()) {
            searchByName(query)
        }

        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText?.length == 0) {
            getCardsRecycler()
        }

        return true
    }
}