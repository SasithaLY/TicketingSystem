package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;


public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDAO userDAO = null;

    public UserController() {
        userDAO = new UserDAOImpl();
 
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User> userList = userDAO.get();
		
		request.setAttribute("userList", userList);
		
		RequestDispatcher dispatcher =  request.getRequestDispatcher("/UsersList.jsp");
	 
		dispatcher.forward(request, response);
	 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
