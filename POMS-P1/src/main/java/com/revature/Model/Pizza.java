package com.revature.Model;

public class Pizza {
	private int pizzaId;
	private String pizzaType;
	 private String pizzaSize;
	 private String pizzaCategory;
	 private int pizzaPrice;
	public Pizza(int pizzaId, String pizzaType, String pizzaSize, String pizzaCategory, int pizzaPrice) {
		super();
		this.pizzaId = pizzaId;
		this.pizzaType = pizzaType;
		this.pizzaSize = pizzaSize;
		this.pizzaCategory = pizzaCategory;
		this.pizzaPrice = pizzaPrice;
	}
	public int getPizzaId() {
		return pizzaId;
	}
	public Pizza() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}
	public String getPizzaType() {
		return pizzaType;
	}
	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}
	public String getPizzaSize() {
		return pizzaSize;
	}
	public void setPizzaSize(String pizzaSize) {
		this.pizzaSize = pizzaSize;
	}
	public String getPizzaCategory() {
		return pizzaCategory;
	}
	public void setPizzaCategory(String pizzaCategory) {
		this.pizzaCategory = pizzaCategory;
	}
	public int getPizzaPrice() {
		return pizzaPrice;
	}
	public void setPizzaPrice(int pizzaPrice) {
		this.pizzaPrice = pizzaPrice;
	}
	
	 
	 		
	
}
