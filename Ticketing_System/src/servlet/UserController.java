package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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


public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDAO userDAO = null;
	
	RequestDispatcher dispatcher = null;

    public UserController() {
        userDAO = new UserDAOImpl();
 
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String action = request.getParameter("action");
	
	HttpSession session = request.getSession();
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			case "LIST":
				listUsers(request, response);
				break;
				
			case "EDIT":
				getSingleUser(request, response);
				break;
				
			case "REMOVE":
				removeUser(request, response);
				break;
			
			case "LOGOUT":
				logout(request, response);
				break;
						
			case "VIEW":
				System.out.println(session.getAttribute("id"));
				//request.setAttribute("id", session.getAttribute("id"));
				viewProfile(request, response);
				break;
				
			case "REGISTER":
//				request.setAttribute("username", request.getParameter("username"));
//				request.setAttribute("password", request.getParameter("password"));
				register(request, response);
				break;
				
			default:
				listUsers(request, response);
				break;
				
		}
	 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		HttpSession session = request.getSession();
		
//		if(action == null) {
//			String id = request.getParameter("userId");
//			String uname = request.getParameter("Username");
//			String pwd = request.getParameter("password");
//			String firstName = request.getParameter("firstName");
//			String lastName = request.getParameter("lastName");
//			String address = request.getParameter("address");
//			String dob = request.getParameter("dob");
//			String nic = request.getParameter("nic");
//					
//			User user = new User();
//			user.setUsername(uname);
//			user.setPassword(pwd);
//			user.setUserId(Integer.parseInt(id));
//			user.setFirstName(firstName);
//			user.setLastName(lastName);
//			user.setAddress(address);
//			user.setDob(dob);
//			user.setNic(nic);
//			
//			if(userDAO.update(user)) {
//
//				JOptionPane.showMessageDialog(null, "Successfully Updated!");
//				viewProfile(request, response);
//				
//			}else {
//				listUsers(request, response);
//			}
//		}
		
		switch(action) {
		case "LIST":
			listUsers(request, response);
			break;
			
		case "EDIT":
			getSingleUser(request, response);
			break;
			
		case "REMOVE":
			removeUser(request, response);
			break;
		
		case "LOGOUT":
			logout(request, response);
			break;
			
		case "LOGIN":
			login(request, response);
			break;
			
		case "UPDATE":
			update(request, response);
			break;
			
		case "REGISTER":
//			request.setAttribute("username", request.getParameter("username"));
//			request.setAttribute("password", request.getParameter("password"));
			register(request, response);
			break;
			
		default:
			listUsers(request, response);
			break;
			
	}
		
	}

	
	public void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> userList = userDAO.get();
		
		request.setAttribute("userList", userList);
		
		dispatcher =  request.getRequestDispatcher("/UsersList.jsp");
		
		dispatcher.forward(request, response);
	}
	
	
	
	public void getSingleUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		if(id.equals("0")) {
			
			id = session.getAttribute("id").toString(); 
		}
		User user = userDAO.get(Integer.parseInt(id));
		request.setAttribute("user", user);
		System.out.println("In getSingle user = uname:"+request.getAttribute("username")+" pw: "+request.getAttribute("password")+" type: "+request.getAttribute("logType")+" ID: "+id );

		dispatcher =  request.getRequestDispatcher("/EditProfile.jsp");
		
		dispatcher.forward(request, response);
	}
	
	public void viewProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		
		if(session.getAttribute("id") == null) {
			dispatcher =  request.getRequestDispatcher("/Login.jsp");
			
			dispatcher.forward(request, response);
		}else {
			String id = session.getAttribute("id").toString();
			User user = userDAO.get(Integer.parseInt(id));
			request.setAttribute("user", user);
			
			dispatcher =  request.getRequestDispatcher("/ViewProfile.jsp");
			
			dispatcher.forward(request, response);
		}
		
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.removeAttribute("password");
		session.invalidate();
	    
		dispatcher =  request.getRequestDispatcher("/Home.jsp");
		
		dispatcher.forward(request, response);
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		String logType = request.getParameter("logType").toString();
		
		//String id = request.getParameter("id").toString();
			
		System.out.println(logType);
		System.out.println(pwd);
		User user = userDAO.login(uname);
		
		
		if(logType.equals("register")) {
	
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			session.setAttribute("password", pwd);
			session.setAttribute("id", user.getUserId());
			session.setAttribute("type", user.getType());
			String id = String.valueOf(user.getUserId());
//			request.setAttribute("id", id);
			System.out.println("In Login = uname:"+uname+" pw: "+pwd+" type: "+request.getAttribute("logType")+" ID: "+id );
			getSingleUser(request, response);
			
		}else if(logType.equals("login")) {
			
			
			if(user != null) {
				String password = user.getPassword().toString();
				String username = user.getUsername().toString();
				
				
				if(password.equals(pwd)) {
					HttpSession session = request.getSession();
					
					session.setAttribute("username", uname);
					session.setAttribute("password", pwd);
					session.setAttribute("id", user.getUserId());
					session.setAttribute("type", user.getType());
					System.out.println("type: "+session.getAttribute("type"));	
				    request.setAttribute("id", user.getUserId());
				    
				    if(session.getAttribute("type").equals("admin")) {
				    	dispatcher =  request.getRequestDispatcher("/AdminPanel.jsp");
						dispatcher.forward(request, response);
				    }else {
				    	viewProfile(request, response);
				    }
					
				
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect Password!");
					dispatcher =  request.getRequestDispatcher("/Login.jsp");
					dispatcher.forward(request, response);
				}

			
			}else {
				JOptionPane.showMessageDialog(null, "Incorrect Username!");
				dispatcher =  request.getRequestDispatcher("/Login.jsp");
				dispatcher.forward(request, response);
			}
			
		}
		
	}
	
	public void removeUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		
	    if(userDAO.remove(Integer.parseInt(id))){
	    	JOptionPane.showMessageDialog(null, "Successfully Removed User!");
	    }
	    listUsers(request, response);
	}
	
	
	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		String passwordRepeat = request.getParameter("password-repeat");
		
		User user = new User();
		user.setUsername(uname);
		user.setPassword(pwd);
		user.setType("user");
		
		if(userDAO.register(user)) {
			
			JOptionPane.showMessageDialog(null, "Successfully Registered!");
			
		}
		request.setAttribute("username", uname);
		request.setAttribute("password", pwd);
		request.setAttribute("logType", "register");
		System.out.println("In Register = uname:"+request.getAttribute("username")+" pw: "+request.getAttribute("password")+" type: "+request.getAttribute("logType")+" ID: "+user.getUserId() );
		login(request, response);

	}
	
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userId");
		String uname = request.getParameter("Username");
		String pwd = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String dob = request.getParameter("dob");
		String nic = request.getParameter("nic");
				
		User user = new User();
		user.setUsername(uname);
		user.setPassword(pwd);
		user.setUserId(Integer.parseInt(id));
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAddress(address);
		user.setDob(dob);
		user.setNic(nic);
		
		if(userDAO.update(user)) {

			JOptionPane.showMessageDialog(null, "Successfully Updated!");
			viewProfile(request, response);
			
		}else {
			listUsers(request, response);
		}
	}
}
