package com.revature.Model;

public class Cookie {
	
	String cookieId;
	String cookieName;
	String cookiePrice;
	public Cookie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cookie(String cookieId, String cookieName, String cookiePrice) {
		super();
		this.cookieId = cookieId;
		this.cookieName = cookieName;
		this.cookiePrice = cookiePrice;
	}
	public String getCookieId() {
		return cookieId;
	}
	public void setCookieId(String cookieId) {
		this.cookieId = cookieId;
	}
	public String getCookieName() {
		return cookieName;
	}
	public void setCookieName(String cookieName) {
		this.cookieName = cookieName;
	}
	public String getCookiePrice() {
		return cookiePrice;
	}
	public void setCookiePrice(String cookiePrice) {
		this.cookiePrice = cookiePrice;
	}
	
}
