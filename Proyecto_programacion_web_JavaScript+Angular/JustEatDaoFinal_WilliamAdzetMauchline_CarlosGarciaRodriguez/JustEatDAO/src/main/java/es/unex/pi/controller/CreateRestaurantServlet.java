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

import es.unex.pi.dao.CategoryDAO;
import es.unex.pi.dao.DishDAO;
import es.unex.pi.dao.JDBCCategoryDAOImpl;
import es.unex.pi.dao.JDBCDishDAOImpl;
import es.unex.pi.dao.JDBCRestaurantCategoriesDAOImpl;
import es.unex.pi.dao.JDBCRestaurantDAOImpl;
import es.unex.pi.dao.JDBCUserDAOImpl;
import es.unex.pi.dao.RestaurantCategoriesDAO;
import es.unex.pi.dao.RestaurantDAO;
import es.unex.pi.dao.UserDAO;
import es.unex.pi.model.Category;
import es.unex.pi.model.Dish;
import es.unex.pi.model.Restaurant;
import es.unex.pi.model.RestaurantCategories;
import es.unex.pi.model.User;

/**
 * Servlet implementation class DetailRestaurantServlet
 */
@WebServlet("/CreateRestaurantServlet.do")
public class CreateRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateRestaurantServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		CategoryDAO catDao = new JDBCCategoryDAOImpl();
		catDao.setConnection(conn);
		List<Category> categories = catDao.getAll();
		request.setAttribute("categories", categories);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/CreateRestaurant.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		RestaurantDAO restaurantDao = new JDBCRestaurantDAOImpl();
		RestaurantCategoriesDAO restCatDao = new JDBCRestaurantCategoriesDAOImpl();
		CategoryDAO catDao = new JDBCCategoryDAOImpl();
		restaurantDao.setConnection(conn);
		restCatDao.setConnection(conn);
		catDao.setConnection(conn);

		Restaurant restaurant = new Restaurant();
		List<Category> categories = catDao.getAll();

		

		restaurant.setAddress(request.getParameter("address"));
		restaurant.setCity(request.getParameter("city"));
		restaurant.setName(request.getParameter("name"));
		restaurant.setTelephone(request.getParameter("telephone"));
		restaurant.setContactEmail(request.getParameter("email"));
		restaurant.setMinPrice(Integer.parseInt(request.getParameter("minPrice")));
		restaurant.setMaxPrice(Integer.parseInt(request.getParameter("maxPrice")));
		if (request.getParameter("bikeFriendly").equals("Yes")) {
			restaurant.setBikeFriendly(1);
		} else {
			restaurant.setBikeFriendly(0);
		}
		if (request.getParameter("available").equals("Yes")) {
			restaurant.setAvailable(1);
		} else {
			restaurant.setAvailable(0);
		}
		
		Long id = restaurantDao.add(restaurant);
		for (Category cat : categories) {
			RestaurantCategories rc = new RestaurantCategories();
			rc.setIdct(cat.getId());
			rc.setIdr(id);
			if (request.getParameter(cat.getName()) != null) {
				restCatDao.add(rc);
			}
		}

		response.sendRedirect("SearchServlet.do");
	}

}