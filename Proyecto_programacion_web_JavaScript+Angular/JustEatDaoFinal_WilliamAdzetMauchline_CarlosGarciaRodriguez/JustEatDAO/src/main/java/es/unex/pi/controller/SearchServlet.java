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

import es.unex.pi.dao.JDBCRestaurantDAOImpl;
import es.unex.pi.dao.RestaurantDAO;
import es.unex.pi.model.Restaurant;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet.do")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Search.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		
		RestaurantDAO restaurantDao = new JDBCRestaurantDAOImpl();
		restaurantDao.setConnection(conn);
		if(request.getParameter("query")=="") {
			response.sendRedirect("SearchServlet.do");
			return;
		}
		
		List <Restaurant> restaurantList = restaurantDao.getAllBySearchName(request.getParameter("query"));
		List <Restaurant> restaurantListCity = restaurantDao.getAllBySearchCity(request.getParameter("query"));
		
		if(restaurantList.isEmpty()) {
			restaurantList = restaurantListCity;
		}else {
			for(Restaurant rest: restaurantListCity) {
				for(Restaurant rest2: restaurantList) {
					if(rest.getId()!= rest2.getId())
						restaurantList.add(rest);
				}
			}
		}
		
		Iterator<Restaurant> iter = restaurantList.iterator();
		if(request.getParameter("acceptOrders")!=null) {
			while(iter.hasNext()) {
				Restaurant rest = iter.next();
				if(rest.getAvailable()==0)
					iter.remove();
			}
		}
		
		if(request.getParameter("noAcceptOrders")!=null) {
			while(iter.hasNext()) {
				Restaurant rest = iter.next();
				if(rest.getAvailable()==1)
					iter.remove();
			}
		}
		
		request.setAttribute("restaurantList", restaurantList);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/SearchContent.jsp");
		view.forward(request, response);
				
	}

}
