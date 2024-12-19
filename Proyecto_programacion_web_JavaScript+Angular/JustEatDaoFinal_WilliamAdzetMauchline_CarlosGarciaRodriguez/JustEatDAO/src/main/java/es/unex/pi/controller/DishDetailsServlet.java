package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import es.unex.pi.dao.DishDAO;
import es.unex.pi.dao.JDBCDishDAOImpl;
import es.unex.pi.dao.JDBCRestaurantDAOImpl;
import es.unex.pi.dao.JDBCUserDAOImpl;
import es.unex.pi.dao.RestaurantDAO;
import es.unex.pi.dao.UserDAO;
import es.unex.pi.model.Dish;
import es.unex.pi.model.Restaurant;
import es.unex.pi.model.User;

/**
 * Servlet implementation class DetailRestaurantServlet
 */
@WebServlet("/DishDetailsServlet.do")
public class DishDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DishDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		DishDAO dishesDao = new JDBCDishDAOImpl();
		dishesDao.setConnection(conn);
		Long dishId = Long.parseLong(request.getParameter("dishId"));
		request.setAttribute("dish", dishesDao.get(dishId));
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/DishDetails.jsp");
	    view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		DishDAO dishesDao = new JDBCDishDAOImpl();
		dishesDao.setConnection(conn);
		Dish dish = dishesDao.get(Long.parseLong(request.getParameter("dishId")));
		
		String delete = request.getParameter("Delete");
		String dishName = request.getParameter("dishName");
		int dishPrice = Integer.parseInt(request.getParameter("dishPrice"));
		String dishDescription = request.getParameter("dishDescription");
		
		if(delete!=null) {
			dishesDao.delete(dish.getId());
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Search.jsp");
			view.forward(request, response);
		}else {
			dish.setName(dishName);
			dish.setPrice(dishPrice);
			dish.setDescription(dishDescription);
			dishesDao.update(dish);
			
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Search.jsp");
			view.forward(request, response);
		}
		
	}

}
