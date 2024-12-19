package es.unex.pi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import es.unex.pi.dao.JDBCUserDAOImpl;
import es.unex.pi.dao.UserDAO;
import es.unex.pi.model.User;


/**
 * Servlet implementation class ModifyUserServlet
 */
@WebServlet("/ModifyUserServlet.do")
public class ModifyUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/DetailUser.jsp");
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
		
		HttpSession session = request.getSession();
		User userSession = (User) session.getAttribute("user");
		
		String butonValue = request.getParameter("editacc");
		if(butonValue != null) {
			User user = new User();
			user.setId(userSession.getId());
			user.setName(request.getParameter("name"));
			user.setSurname(request.getParameter("surname"));
			user.setEmail(request.getParameter("email"));
			user.setPassword(request.getParameter("password"));
			
			userDao.update(user);
			response.sendRedirect("SearchServlet.do");
		} else {
			butonValue = request.getParameter("deleteacc");
			if(butonValue != null) {
				userDao.delete(userSession.getId());
				response.sendRedirect("LoginServlet.do");
			}		
		}	
	}

}
