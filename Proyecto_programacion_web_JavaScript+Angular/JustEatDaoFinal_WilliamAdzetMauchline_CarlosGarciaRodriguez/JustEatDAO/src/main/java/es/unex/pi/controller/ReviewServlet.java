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

import es.unex.pi.dao.JDBCOrderDAOImpl;
import es.unex.pi.dao.JDBCRestaurantDAOImpl;
import es.unex.pi.dao.JDBCReviewsDAOImpl;
import es.unex.pi.dao.JDBCUserDAOImpl;
import es.unex.pi.dao.OrderDAO;
import es.unex.pi.dao.UserDAO;
import es.unex.pi.dao.RestaurantDAO;
import es.unex.pi.dao.ReviewsDAO;
import es.unex.pi.model.Restaurant;
import es.unex.pi.model.Review;
import es.unex.pi.model.User;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/ReviewServlet.do")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		RestaurantDAO restaurantDao = new JDBCRestaurantDAOImpl();
		restaurantDao.setConnection(conn);
		Long restaurantId = Long.parseLong(request.getParameter("id"));
		Restaurant restaurant = restaurantDao.get(restaurantId);
		
		request.setAttribute("restaurant", restaurant);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Review.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		HttpSession session = request.getSession();
		User userSession = (User) session.getAttribute("user"); 
		ReviewsDAO reviewsDao = new JDBCReviewsDAOImpl();
		reviewsDao.setConnection(conn);
		RestaurantDAO restaurantDao = new JDBCRestaurantDAOImpl();
		restaurantDao.setConnection(conn);
		
		Review review = new Review();
		
		Long restaurantId = Long.parseLong(request.getParameter("restaurantid"));
		
		Integer grade = Integer.parseInt(request.getParameter("valoration"));
		
		review.setIdr(restaurantId);
		review.setIdu(userSession.getId());
		review.setReview(request.getParameter("review"));
		review.setGrade(grade);
		
		
	    if(reviewsDao.get(restaurantId, userSession.getId()) == null) {
	    	reviewsDao.add(review);
	    	Restaurant restaurant = restaurantDao.get(restaurantId);
	    	double avgGrade = reviewsDao.getAvgGradeByIdr(restaurantId);
	    	
	    	restaurant.setGradesAverage(avgGrade);
	    	restaurantDao.update(restaurant);
	    }
	    else {
	    	System.out.println("You already reviewed this restaurant");
	    }
		
		response.sendRedirect("SearchServlet.do");
	}

}
