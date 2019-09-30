package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBConnectionUtil;

public class TravelPackage {
	
	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;
	PreparedStatement preparedStatement = null;

	private int packageId;
	private String packageType;
	private int duration;
	private double loanAmount;
	private double packagePrice;
	private String packageName;
	private String description;
	private String specialOffer;
		
	public TravelPackage() {
		super();		
	}

	public int getPackageId() {
		return packageId;
	}


	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}


	public String getPackageType() {
		return packageType;
	}


	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public double getLoanAmount() {
		return loanAmount;
	}


	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}


	public double getPackagePrice() {
		return packagePrice;
	}


	public void setPackagePrice(double packagePrice) {
		this.packagePrice = packagePrice;
	}


	public String getPackageName() {
		return packageName;
	}


	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getSpecialOffer() {
		return specialOffer;
	}


	public void setSpecialOffer(String specialOffer) {
		this.specialOffer = specialOffer;
	}
	
	
	
	public boolean addPackage(String type, int duration, double loanAmount, double packagePrice, String packageName, String Description, String specialOffer ) {
		boolean flag = false;
		
		try {
			
			String sql = "INSERT INTO package(packageType, duration, loanAmount, packagePrice, packageName, description, specialOffer) "
					+ "values('"+type+"','"+duration+"', '"+loanAmount+"', '"+packagePrice+"', '"+packageName+"', '"+description+"', '"+specialOffer+"')";
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql); 
			preparedStatement.executeUpdate();
			
			flag = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	
	}
	
	
	public List<TravelPackage> getPackages() {

		List<TravelPackage> list = null;
		TravelPackage pk = null;
		
		try {
			list = new ArrayList<TravelPackage>();
			
			String sql = "SELECT * FROM package";
			
			connection = DBConnectionUtil.openConnection();

			statement = connection.createStatement();
			
			resultset = statement.executeQuery(sql);
		
			
			while(resultset.next()) {
				pk = new TravelPackage();
				
				pk.setPackageId(resultset.getInt("packageId"));
				pk.setPackageType(resultset.getString("packageType"));
				pk.setDuration(resultset.getInt("duration"));
				pk.setLoanAmount(resultset.getDouble("loanAmount"));
				pk.setPackagePrice(resultset.getDouble("packagePrice"));
				pk.setPackageName(resultset.getString("packageName"));
				pk.setDescription(resultset.getString("description"));
				pk.setSpecialOffer(resultset.getString("specialOffer"));
				
				list.add(pk);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public boolean activatePackage(int userId, int packageId) {
		boolean flag = false;
		
		try {
			
			String sql1 = "UPDATE user SET packageId='"+packageId+"' WHERE userId='"+userId+"'";
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql1); 
			preparedStatement.executeUpdate();
			
			flag = true;
		}catch(Exception e) {
			
		}
		
		return flag;
	}
	

	public boolean updatePackage(TravelPackage p) {
		
		boolean flag = false;
		
		try {
			
			String sql = "UPDATE package SET packageType='"+p.getPackageType()+"', duration='"+p.getDuration()+"', loanAmount='"+p.getLoanAmount()+"', packagePrice='"+p.getPackagePrice()+"', "
					+ "packageName='"+p.getPackageName()+"',description='"+p.getDescription()+"', specialOffer='"+p.getSpecialOffer()+"' WHERE packageId="+p.getPackageId();
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql); 
			preparedStatement.executeUpdate();
			flag = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
	public boolean removePackage(int packageId) {
		
		boolean flag = false;
		
		try {
			
			String sql = "DELETE FROM package WHERE packageId="+packageId;
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
