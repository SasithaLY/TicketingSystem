package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.google.zxing.WriterException;

class UserTest {

	User u; 
	

	
	@Test
	void checkAcountBalanceTest1() {
		u = new User();	
		assertEquals(200, u.checkAccountBalance(2));
	}
	 
	@Test
	void checkAcountBalanceTest2() {
		u = new User();	
		assertEquals(0, u.checkAccountBalance(2));
	}
	
	@Test
	void ValidUserTest1() {
		u = new User();
		User loggedInUser  = u.login("kee", "kee123");
		assertEquals("Keerthana", loggedInUser.getFirstName());
	}
	
	@Test
	void ValidUserTest2() {
		u = new User();
		User loggedInUser  = u.login("kee", "kee123");
		assertEquals("Kee", loggedInUser.getFirstName());
	}

	@Test
	void requestLoanTest1() {
		u = new User();
		assertEquals(true, u.requestLoan(1));
	}
	 
	@Test
	void requestLoanTest2() {
		u = new User();
		assertEquals(false, u.requestLoan(2));
	}
	
	@Test
	void createQRCTest() throws WriterException, IOException {
		u = new User();
		assertEquals(null, u.createQRC("test", 500, 500));
	}
}
