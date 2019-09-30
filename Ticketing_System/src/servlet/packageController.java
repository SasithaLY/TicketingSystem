package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import model.TravelPackage;
import model.User;


public class packageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RequestDispatcher dispatcher = null;
	
	TravelPackage pack = null;

    public packageController() {
    	pack = new TravelPackage();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		HttpSession session = request.getSession();
		
		switch(action) {
			case "LIST":
				listPackages(request, response);
				break;
				
			case "EDIT":
				//getSingleUser(request, response);
				break;
				
			case "REMOVE":
				removePackage(request, response);
				break;
			
			case "LOGOUT":
				//logout(request, response);
				break;
				
			case "LOGIN":
				//login(request, response);
				break;
				
			case "UPDATE":
				//update(request, response);
				break;
				
			case "REGISTER":
				//register(request, response);
				break;
				
			case "ADMIN":
				//addAdmin(request, response);
				break;
				
			case "SaveCard":
				//saveCreditCard(request, response);
				break;
				
			case "balance":
				//accountBalance(request, response);
				break;
				
			default:
				listPackages(request, response);
				break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		HttpSession session = request.getSession();
		
		switch(action) {
			case "LIST":
				listPackages(request, response);
				break;
				
			case "EDIT":
				//getSingleUser(request, response);
				break;
				
			case "REMOVE":
				//removeUser(request, response);
				break;
			
			case "LOGOUT":
				//logout(request, response);
				break;
				
			case "LOGIN":
				//login(request, response);
				break;
				
			case "UPDATE":
				//update(request, response);
				break;
				
			case "REGISTER":
				//register(request, response);
				break;
				
			case "ADMIN":
				//addAdmin(request, response);
				break;
				
			case "SaveCard":
				//saveCreditCard(request, response);
				break;
				
			case "balance":
				//accountBalance(request, response);
				break;
				
			default:
				listPackages(request, response);
				break;
		}
	}
	
	public void listPackages(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		
		List<TravelPackage> packageList = pack.getPackages();
		
		request.setAttribute("packageList", packageList);
		
		dispatcher =  request.getRequestDispatcher("/PackageList.jsp");
		
		dispatcher.forward(request, response);
	}
	
	public void removePackage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		
	    if(pack.removePackage(Integer.parseInt(id))){
	    	JOptionPane.showMessageDialog(null, "Successfully Removed Package!");
	    }
	    listPackages(request, response);
	}

}
