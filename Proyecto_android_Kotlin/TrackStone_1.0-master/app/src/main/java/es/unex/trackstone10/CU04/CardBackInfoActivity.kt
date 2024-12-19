package es.unex.trackstone10.CU04

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import es.unex.trackstone10.API.CardBackResponse
import es.unex.trackstone10.AppExecutors
import es.unex.trackstone10.ButtonNavigationMenuActivity
import es.unex.trackstone10.databinding.ActivityCardBackInfoBinding
import es.unex.trackstone10.roomdb.Entity.CardBackEntity
import es.unex.trackstone10.roomdb.TrackstoneDatabase

class CardBackInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCardBackInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardBackInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val cardBacks = intent.getSerializableExtra("CARD_BACK_OBJ") as CardBackResponse
        binding.cardBackDetailsName.text = cardBacks.name
        binding.cardBackDetail1.text = cardBacks.text
        Glide.with(binding.cardBackDetails.context).load(cardBacks.image).into(binding.cardBackDetails)

        val sharedPreferences = getSharedPreferences("userid", Context.MODE_PRIVATE)
        var userId = sharedPreferences.getInt("userid", 0)

        binding.addCardBackFavorite.setOnClickListener {
            AppExecutors.instance?.diskIO()?.execute {
                val db = TrackstoneDatabase.getInstance(this)
                db?.cardbackdao?.insert(
                    CardBackEntity(
                        cardBacks.name,
                        cardBacks.image,
                        userId
                    )
                )

            }
            this.finish()
        }

    }
}