package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionUtil {

	//database properties
	private static final String username = "root";
	private static final String password = "Sasitha@19951120";
	private static final String jdbcUrl = "jdbc:mysql://localhost:3306/ticketingsystemdb";
	private static final String driver = "com.mysql.jdbc.Driver";
	private static Connection connection = null;
	
	
	//get database connection
	
	public static Connection openConnection() {
		
		if(connection != null) {
			
			return connection;
		}else {
			try {
				Class.forName(driver);
				connection = DriverManager.getConnection(jdbcUrl, username, password);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return connection;
		}
	}
}
