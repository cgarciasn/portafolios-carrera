package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import es.unex.pi.dao.DishDAO;
import es.unex.pi.dao.JDBCDishDAOImpl;
import es.unex.pi.dao.JDBCOrderDAOImpl;
import es.unex.pi.dao.JDBCOrderDishesDAOImpl;
import es.unex.pi.dao.OrderDAO;
import es.unex.pi.dao.OrderDishesDAO;
import es.unex.pi.model.Dish;
import es.unex.pi.model.Order;
import es.unex.pi.model.OrderDishes;
import es.unex.pi.model.User;

import java.io.IOException;
import java.sql.Connection;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet.do")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Dish> dishList = new ArrayList<>();
		dishList = (List<Dish>) session.getAttribute("cart");
		request.setAttribute("dishList", dishList);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Cart.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		OrderDAO orderDao = new JDBCOrderDAOImpl();
		OrderDishesDAO orderDishesDao = new JDBCOrderDishesDAOImpl();
		DishDAO dishDao = new JDBCDishDAOImpl();
		orderDao.setConnection(conn);
		orderDishesDao.setConnection(conn);
		dishDao.setConnection(conn);
		
		HttpSession session = request.getSession();
		User userSession = (User) session.getAttribute("user");
		List<Dish> dishCart = (List<Dish>) session.getAttribute("cart");
		
		
		
		for(Dish dish: dishCart) {
			if(request.getParameter(dish.getName())!=null) {
				dishCart.remove(dish);
				response.sendRedirect("ConfirmedOrderServlet.do");
				return;
			}
		}
		
		Order order = new Order();
		order.setIdu(userSession.getId());		
		for(Dish dish: dishCart) {
			int price = dish.getPrice() + order.getTotalPrice();
			order.setTotalPrice(price);
		}		
		Long orderId = orderDao.add(order);
		
		
	
		
		for(Dish dish: dishCart) {
			OrderDishes orderDishes = new OrderDishes();
			orderDishes.setIdo(orderId);
			orderDishes.setIddi(dish.getId());
			orderDishesDao.add(orderDishes);
		}
		
		dishCart = new ArrayList<>();
		session.setAttribute("cart", dishCart);		
		response.sendRedirect("SearchServlet.do");
	}

}
