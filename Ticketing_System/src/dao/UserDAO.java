package dao;

import java.util.List;

import model.User;

public interface UserDAO {

	List<User> get();
	
	boolean register(User u);
	
	User get(int id);
	
	boolean update(User u);
	
	boolean remove(int id);
	
	User login(String username);
	
	
}
