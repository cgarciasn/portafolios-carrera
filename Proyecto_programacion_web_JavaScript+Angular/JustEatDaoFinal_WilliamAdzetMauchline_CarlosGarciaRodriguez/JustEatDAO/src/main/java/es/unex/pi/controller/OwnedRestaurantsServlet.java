package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import es.unex.pi.dao.DishDAO;
import es.unex.pi.dao.JDBCDishDAOImpl;
import es.unex.pi.dao.JDBCRestaurantDAOImpl;
import es.unex.pi.dao.RestaurantDAO;
import es.unex.pi.model.Dish;
import es.unex.pi.model.Restaurant;
import es.unex.pi.model.User;

/**
 * Servlet implementation class OwnedRestaurantsServlet
 */
@WebServlet("/OwnedRestaurantsServlet.do")
public class OwnedRestaurantsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OwnedRestaurantsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		RestaurantDAO restaurantDao = new JDBCRestaurantDAOImpl();
		restaurantDao.setConnection(conn);
		
		List <Restaurant> ownedRestaurantsList = restaurantDao.getAllByUser(user.getId());
		
		request.setAttribute("ownedRestaurantsList", ownedRestaurantsList);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/OwnedRestaurant.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
