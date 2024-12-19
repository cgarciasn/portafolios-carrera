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
import java.util.*;

import es.unex.pi.dao.*;
import es.unex.pi.model.*;

/**
 * Servlet implementation class DetailRestaurantServlet
 */
@WebServlet("/DetailRestaurantServlet.do")
public class DetailRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailRestaurantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
			
		RestaurantDAO restaurantDao = new JDBCRestaurantDAOImpl();
		RestaurantCategoriesDAO restCatDao = new JDBCRestaurantCategoriesDAOImpl();
		CategoryDAO catDao = new JDBCCategoryDAOImpl();
		
		restaurantDao.setConnection(conn);
		restCatDao.setConnection(conn);
		catDao.setConnection(conn);
		
		Long id = Long.parseLong(request.getParameter("id"));		
		Restaurant restaurant = restaurantDao.get(id);
		List<RestaurantCategories> resCt = restCatDao.getAllByRestaurant(id);
		List<Category> categories = catDao.getAll();
		
		Iterator<Category> iter = categories.iterator();
		while(iter.hasNext()) {
			Category cat = iter.next();
			boolean exists = false;
			for(RestaurantCategories rsCat: resCt) {
				if(cat.getId()==rsCat.getIdct())
					exists = true;
			}
			if(!exists) {
				iter.remove();
			}else {
				exists = false;
			}
		}
		
		
		request.setAttribute("categories", categories);
		request.setAttribute("restaurant", restaurant);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/DetailsRestaurant.jsp");
		view.forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		
		RestaurantDAO restaurantDao = new JDBCRestaurantDAOImpl();
		restaurantDao.setConnection(conn);
		
		Restaurant restaurant = new Restaurant();
		
		request.setAttribute("restaurant", restaurant);
	}

}
