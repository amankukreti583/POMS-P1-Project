package com.revature.Model;

public class Beverage {
	
	String beverageId ;
	String beverageName;
	String beverageType;
	String beveragePrice;
	public Beverage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Beverage(String beverageId, String beverageName, String beverageType, String beveragePrice) {
		super();
		this.beverageId = beverageId;
		this.beverageName = beverageName;
		this.beverageType = beverageType;
		this.beveragePrice = beveragePrice;
	}
	public String getBeverageId() {
		return beverageId;
	}
	public void setBeverageId(String beverageId) {
		this.beverageId = beverageId;
	}
	public String getBeverageName() {
		return beverageName;
	}
	public void setBeverageName(String beverageName) {
		this.beverageName = beverageName;
	}
	public String getBeverageType() {
		return beverageType;
	}
	public void setBeverageType(String beverageType) {
		this.beverageType = beverageType;
	}
	public String getBeveragePrice() {
		return beveragePrice;
	}
	public void setBeveragePrice(String beveragePrice) {
		this.beveragePrice = beveragePrice;
	}

	@Override
	public String toString() {
		return "Beverage [beverageId=" + beverageId + ", beverageName=" + beverageName + ", beverageType="
				+ beverageType + ", beveragePrice=" + beveragePrice + "]";
	}
	
}
