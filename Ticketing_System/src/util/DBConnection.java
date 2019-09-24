package util;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class DBConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DBConnection() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = "root";
		String password = "Sasitha@19951120";
		String jdbcUrl = "jdbc:mysql://localhost:3306/ticketingSystemDB";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			PrintWriter writer = response.getWriter();
			
			writer.println("Connecting to database "+jdbcUrl);
			
			Class.forName(driver);
			
			Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
			writer.println("connection successfull!");
			connection.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
