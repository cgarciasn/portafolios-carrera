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
import java.util.ArrayList;
import java.util.TreeMap;

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

/**
 * Servlet implementation class HistoricalServlet
 */
@WebServlet("/HistoricalServlet.do")
public class HistoricalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoricalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		HttpSession session = request.getSession();
		User userSession = (User) session.getAttribute("user");
		OrderDAO orderDao = new JDBCOrderDAOImpl();
		OrderDishesDAO orderDishesDao = new JDBCOrderDishesDAOImpl();
		DishDAO dishDao = new JDBCDishDAOImpl();
		orderDao.setConnection(conn);
		orderDishesDao.setConnection(conn);
		dishDao.setConnection(conn);
		
		Long userId = userSession.getId();
		
		List<Order> orderListByUser = orderDao.getOrderByUser(userId);
		List<OrderDishes> orderDishes = orderDishesDao.getAll();
		TreeMap<Long,List<Dish>> displaymap = new TreeMap<>();
		
		for(Order order: orderListByUser) {
			List<Dish> auxList = new ArrayList<>();
			for(OrderDishes orderD: orderDishes) {
				if(order.getId() == orderD.getIdo()){
					auxList.add(dishDao.get(orderD.getIddi()));
				}
			}
			displaymap.put(order.getId(),auxList);		
		}
		
		
		request.setAttribute("orderListByUser", orderListByUser);
		request.setAttribute("displaymap", displaymap);	
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Historical.jsp");
	    view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
