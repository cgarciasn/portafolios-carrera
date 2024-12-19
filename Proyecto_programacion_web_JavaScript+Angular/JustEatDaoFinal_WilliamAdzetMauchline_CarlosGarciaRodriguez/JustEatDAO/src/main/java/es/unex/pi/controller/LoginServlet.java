package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import java.sql.Connection;
import java.util.List;

import es.unex.pi.dao.JDBCUserDAOImpl;
import es.unex.pi.dao.UserDAO;
import es.unex.pi.model.Dish;
import es.unex.pi.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/Login.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = (Connection) getServletContext().getAttribute("dbConn");

		UserDAO userDao = new JDBCUserDAOImpl();
		userDao.setConnection(conn);
		List<Dish> dishCart = new ArrayList<>();
		HttpSession session = request.getSession();
		session.setAttribute("cart", dishCart);

		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));

		User useraux = userDao.getUserByEmail(user.getEmail());

		if (useraux != null) {
			if (useraux.getPassword().equals(user.getPassword())) {
				session.setAttribute("user", useraux);

				response.sendRedirect("SearchServlet.do");

			} else {
				System.out.println("Usuario/Contrase�a incorrecto");
			}
		} else {
			System.out.println("Usuario/Contrase�a incorrecto");
		}

	}
}
