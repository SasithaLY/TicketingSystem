package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;


public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDAO userDAO = null;

    public RegisterController() {
    	userDAO = new UserDAOImpl();
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 RequestDispatcher dispatcher =  request.getRequestDispatcher("/Register.jsp");
//		 
//		 dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("Username");
		String password = request.getParameter("password");
		String passwordRepeat = request.getParameter("password-repeat");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		if(userDAO.register(user)) {
			request.setAttribute("message", "Successfully Registered!");
			System.out.println("Success!");
		}
		 RequestDispatcher dispatcher =  request.getRequestDispatcher("/Register.jsp");
		 
		 dispatcher.forward(request, response);
		
		
		
	}

}
