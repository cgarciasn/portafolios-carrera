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
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import es.unex.pi.dao.DishDAO;
import es.unex.pi.dao.JDBCDishDAOImpl;
import es.unex.pi.dao.JDBCOrderDishesDAOImpl;
import es.unex.pi.dao.JDBCOrderDAOImpl;
import es.unex.pi.dao.JDBCRestaurantDAOImpl;
import es.unex.pi.dao.JDBCReviewsDAOImpl;
import es.unex.pi.dao.JDBCUserDAOImpl;
import es.unex.pi.dao.OrderDishesDAO;
import es.unex.pi.dao.OrderDAO;
import es.unex.pi.dao.RestaurantDAO;
import es.unex.pi.dao.ReviewsDAO;
import es.unex.pi.dao.UserDAO;
import es.unex.pi.model.Dish;
import es.unex.pi.model.Restaurant;
import es.unex.pi.model.Review;
import es.unex.pi.model.User;
import es.unex.pi.model.Order;
import es.unex.pi.model.OrderDishes;

/**
 * Servlet implementation class OrderRestaurantServlet
 */
@WebServlet("/OrderRestaurantServlet.do")
public class OrderRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderRestaurantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		
		RestaurantDAO restaurantDao = new JDBCRestaurantDAOImpl();
		DishDAO dishDao = new JDBCDishDAOImpl();
		ReviewsDAO reviewsDao = new JDBCReviewsDAOImpl();
		UserDAO userDao = new JDBCUserDAOImpl();
		restaurantDao.setConnection(conn);
		dishDao.setConnection(conn);
		reviewsDao.setConnection(conn);
		userDao.setConnection(conn);
		
		Long restaurantId = Long.parseLong(request.getParameter("id"));
		Restaurant restaurant = restaurantDao.get(restaurantId);
		
		List <Dish> dishList = dishDao.getAll();
		List <Dish> dishRestaurantList = new ArrayList<>();
		
		TreeMap<String,Review> displaymap = new TreeMap<>();
		
		for (Dish dish : dishList) {
	    	if(dish.getIdr() == restaurantId) {
	    		dishRestaurantList.add(dish);
	    	}
	    }
		
		List <Review> reviewList = reviewsDao.getAllByRestaurant(restaurantId);
		
		for(Review review: reviewList) {
			User user = userDao.get(review.getIdu());
			displaymap.put(user.getName(), review);
		}
		request.setAttribute("displaymap", displaymap);
		request.setAttribute("dishRestaurantList", dishRestaurantList);
		request.setAttribute("restaurant", restaurant);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/OrderRestaurant.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		DishDAO dishDao = new JDBCDishDAOImpl();
		dishDao.setConnection(conn);
		
		HttpSession session = request.getSession();
		List<Dish> dishCart = (List<Dish>) session.getAttribute("cart");
		
		
	
		Dish dish = dishDao.get(Long.parseLong(request.getParameter("dishid")));
		dishCart.add(dish);
		session.setAttribute("cart", dishCart);
		
				
		response.sendRedirect("ConfirmedOrderServlet.do");
	}

}
