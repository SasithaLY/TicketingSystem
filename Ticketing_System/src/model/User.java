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
	
	public User() {
		super();
	}

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
	

	public byte[] createQRC(String text, int width, int height) throws WriterException, IOException {
	    QRCodeWriter qrCodeWriter = new QRCodeWriter();
	    BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
	    
	    ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
	    MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
	    byte[] pngData = pngOutputStream.toByteArray(); 
	    return pngData;
	}
	
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
		
//		String encrytedNumber;
//		byte[] input;
//		byte[] keyBytes = "12345678".getBytes();
//		byte[] ivBytes =  "input123".getBytes();
//		
//		SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
//		IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
//		Cipher cipher;
//		byte[] cipherText;
//		int ctLength;
		
		try {
			
			
//			Security.addProvider(new BouncyCastleJsseProvider());
//			
//			input = creditNo.getBytes();
//			SecretKeySpec nkey = new SecretKeySpec(keyBytes, "DES");
//			IvParameterSpec nivSpec = new IvParameterSpec(ivBytes);
//			
//			cipher = Cipher.getInstance("DES/CTR/NoPadding", "BC");
//			
//			cipher.init(Cipher.ENCRYPT_MODE, nkey, nivSpec);
//			
//			cipherText = new byte[cipher.getOutputSize(input.length)];
//			
//			ctLength = cipher.update(input, 0, input.length, cipherText, 0);
//			
//			ctLength += cipher.doFinal(cipherText, ctLength);
//			
//			encrytedNumber = String.valueOf(cipherText);
//			
//			System.out.println("Encrypted No: "+encrytedNumber);
			
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
	
	
	public String encrypt(String text) {
		String input = text;
		
		
		
		return input;
	}
	
}
