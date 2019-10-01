package model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Security;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.encoder.ByteMatrix;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.*;


import util.DBConnectionUtil;



public class User {
	
	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;
	PreparedStatement preparedStatement = null;
	
	//attributes 
	private int userId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String address;
	private String dob;
	private String nic;
	private String createdDate;
	private int packageId; 
	private int accountId;
	private String type;
	private String status;
	private double accountBalance;
	
	//default constructor
	public User() {
		
	}

	//getters and setters
	public int getUserId() {
		return userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", address=" + address + ", dob=" + dob + ", nic=" + nic
				+ ", createdDate=" + createdDate + ", packageId=" + packageId + ", accountId=" + accountId + ", type="
				+ type + "]";
	}

	
	//Method for creating an account (Register function)
	public boolean createAccount(User u) {
		boolean flag = false;
		
		try {
			
			String sql = "INSERT INTO user(username, password, createdDate, type) values('"+u.getUsername()+"','"+u.getPassword()+"', CURDATE(), '"+u.getType()+"')";
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql); 
			preparedStatement.executeUpdate();
			
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
	//method for login
	public User login(String username, String password) {
		User user = null;
		
		try {
			
			String sql = "SELECT * FROM user WHERE username='"+username+"' AND password='"+password+"'";
			
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
				user.setType(resultset.getString("type"));
				user.setType(resultset.getString("status"));
				user.setType(resultset.getString("accountBalance"));
			
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return user;
	}
	

	//method to generate QR Code
	public byte[] createQRC(String text, int width, int height) throws WriterException, IOException {
	    QRCodeWriter qrCodeWriter = new QRCodeWriter();
	    BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
	    
	    ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
	    MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
	    byte[] pngData = pngOutputStream.toByteArray(); 
	    return pngData;
	}
	
	//method to check available account balance
	public double checkAccountBalance(int userId) {
		
		double balance = 0;
		try {
			
			String sql = "SELECT * FROM user WHERE userId='"+userId+"'";
			
			connection = DBConnectionUtil.openConnection();

			statement = connection.createStatement();
			
			resultset = statement.executeQuery(sql);
		
			while(resultset.next()) {
				
				balance = resultset.getDouble("accountBalance");
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
				
		return balance;
	}
	
	public boolean addCreditCard(String creditNo, String expireDate, int userId) {
		boolean flag = false;
				
		try {

			String sql = "INSERT INTO creditcards(creditCardNo, expireDate, userId) values('"+creditNo+"','"+expireDate+"','"+userId+"')";
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql); 
			preparedStatement.executeUpdate();
			
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
	public boolean validateCreditCard(String creditCardNo, String cvv, String expireDate) {
		
		
		if(creditCardNo.length() != 16) {
			return false;
		}else if(cvv.length() != 3) {
			return false;
		}else if(expireDate.matches("(?:0[1-9]|1[0-2])/[0-9]{2}")) {
			return false;
		}else {
			return true;
		}
		
	} 
	
	
	public boolean requestLoan(int userId) {
		boolean flag = false;
		try {
			connection = DBConnectionUtil.openConnection();

			statement = connection.createStatement();
			
			double amount = 0;
			double loanAmount = 0;
			
			String sql1 = "SELECT loanAmount FROM user u WHERE u.userId='"+userId+"')";
			
			resultset = statement.executeQuery(sql1);
			
			while(resultset.next()){
				loanAmount = resultset.getDouble("loanAmount");
			}
			
			if(loanAmount > 0) {
				return false;
			}else {
				String sql = "SELECT loanAmount FROM package p WHERE p.packageId=(SELECT packageId FROM User u WHERE u.userId='"+userId+"')";
				
				resultset = statement.executeQuery(sql);
				
				while(resultset.next()){
					amount = resultset.getDouble("loanAmount");
				}
				
				if(amount > 0) {
					
					String sql2 = "UPDATE user SET accountBalance=accountBalance+'"+amount+"', loanAmount='"+amount+"'";
					
					preparedStatement = connection.prepareStatement(sql2); 
					preparedStatement.executeUpdate();
					
					flag = true;
				}else {
					flag = false;
				}
			}
		
			
		}catch(Exception e) {
			
		}
		
		
		return flag;
	}
	
	public boolean update(User u) {
		
		boolean flag = false;
		
		try {
			
			String sql = "UPDATE user SET firstName='"+u.getFirstName()+"', lastName='"+u.getLastName()+"', address='"+u.getAddress()+"', dob='"+u.getDob()+"', nic='"+u.getNic()+"' WHERE userId="+u.getUserId();
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql); 
			preparedStatement.executeUpdate();
			flag = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean remove(int id) {
		
		boolean flag = false;
		
		try {
			
			String sql = "DELETE FROM user WHERE userId="+id;
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql); 
			preparedStatement.executeUpdate();
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
}
