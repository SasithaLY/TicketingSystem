package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

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

		response.setContentType("text/html");
		
		String uname = request.getParameter("Username");
		String pwd = request.getParameter("password");
		String passwordRepeat = request.getParameter("password-repeat");
		
		User user = new User();
		user.setUsername(uname);
		user.setPassword(pwd);
		
		if(userDAO.register(user)) {
			
			HttpSession session = request.getSession();
			
			session.setAttribute("username", uname);
			session.setAttribute("password", pwd);
			
			//JOptionPane.showMessageDialog(null, "Successfully Registered!");
			
		}
		HttpSession session = request.getSession();
		
		session.setAttribute("username", uname);
		session.setAttribute("password", pwd);
		
		RequestDispatcher dispatcher =  request.getRequestDispatcher("/EditProfile.jsp");
		dispatcher.forward(request, response);
	
		
		
		
	}

}
