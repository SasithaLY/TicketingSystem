package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;
import util.DBConnectionUtil;

public class UserDAOImpl implements UserDAO {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;
	
	@Override
	public List<User> get() {

		List<User> list = null;
		User user = null;
		
		try {
			list = new ArrayList<User>();
			
			String sql = "SELECT * FROM user";
			
			connection = DBConnectionUtil.openConnection();
			
			statement = connection.createStatement();
			
			resultset = statement.executeQuery(sql);
			
			while(resultset.next()) {
				user = new User();
				
				user.setUserId(resultset.getInt("userId"));
				user.setUsername(resultset.getString("username"));
				user.setPassword(resultset.getString("password"));
				user.setFirstName(resultset.getString("firstName"));
				user.setLastName(resultset.getString("lastName"));
				user.setAddress(resultset.getString("address"));
				user.setDob(resultset.getString("dob"));
				user.setNic(resultset.getString("nic"));
				user.setCreatedDate(resultset.getString("createdDate"));
				user.setAccountId(resultset.getInt("accountId"));
				user.setPackageId(resultset.getInt("packageId"));
				
				list.add(user);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
