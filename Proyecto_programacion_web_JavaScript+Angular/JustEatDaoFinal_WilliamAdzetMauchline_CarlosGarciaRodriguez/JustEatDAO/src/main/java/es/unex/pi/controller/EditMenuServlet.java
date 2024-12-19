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
@WebServlet("/EditMenuServlet.do")
public class EditMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMenuServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		RestaurantDAO restaurantDao = new JDBCRestaurantDAOImpl();
		DishDAO dishesDao = new JDBCDishDAOImpl();
		dishesDao.setConnection(conn);
		restaurantDao.setConnection(conn);
		Long restaurantId = Long.parseLong(request.getParameter("restaurantId"));

		Restaurant restaurant = restaurantDao.get(restaurantId);
		List<Dish> menuOwnedRestaurant = new ArrayList<>();
		List<Dish> menu = dishesDao.getAll();
		for (Dish dish : menu) {
			if (dish.getIdr() == restaurantId) {
				menuOwnedRestaurant.add(dish);
			}
		}
		if (user.getId() == restaurant.getIdu()) {
			request.setAttribute("restaurant", restaurant);
			request.setAttribute("menu", menuOwnedRestaurant);

			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/EditRestaurantMenu.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Connection conn = (Connection) getServletContext().getAttribute("dbConn");

		DishDAO dishDao = new JDBCDishDAOImpl();
		dishDao.setConnection(conn);

		Dish dish = new Dish();
		dish.setIdr(Long.parseLong(request.getParameter("restaurantId")));
		dish.setName(request.getParameter("dishName"));
		dish.setPrice(Integer.parseInt(request.getParameter("dishPrice")));
		dish.setDescription(request.getParameter("dishDescription"));

		dishDao.add(dish);

		response.sendRedirect("SearchServlet.do");
	}

}
