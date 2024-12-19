package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import es.unex.pi.dao.JDBCUserDAOImpl;
import es.unex.pi.dao.UserDAO;
import es.unex.pi.model.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Register.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");
		
		UserDAO userDao = new JDBCUserDAOImpl();
		userDao.setConnection(conn);
		
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setSurname(request.getParameter("surname"));
		
		user.setEmail(request.getParameter("email"));
		
		user.setPassword(request.getParameter("password"));
		
		if(userDao.getUserByEmail(user.getEmail()) == null && user.getPassword().matches("^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,32}$")) {
			userDao.add(user);
		}
		
		response.sendRedirect("LoginServlet.do");
		
	}

}
