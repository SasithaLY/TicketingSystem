package model;

public class Package {

	private int packageId;
	private String packageType;
	private int duration;
	private double loanAmount;
	private double packagePrice;
	private String packageName;
	private String description;
	private String specialOffer;
	
	
	public Package() {
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
	
	
	
	
	
}
