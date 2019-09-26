package dao;

import java.util.List;

import model.User;

public interface UserDAO {

	List<User> get();
	
	boolean register(User u);
}
