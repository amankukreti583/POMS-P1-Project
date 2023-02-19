package com.revature.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.Model.Cookie;
import com.revature.Model.Pizza;

public class CookieDao {

	private Connection conn;

	public CookieDao(Connection conn) {
		super();
		this.conn = conn;
	}



	public CookieDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	String url="jdbc:mysql://localhost:3306/poms";
	String username="root";
	String password="Alapino583@";
	Connection con=null;
	Statement st=null;
	PreparedStatement ps=null;
	
	
	
	public boolean AddCookieDetails(Cookie c)
	{
		boolean j=false;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			ps=con.prepareStatement("insert into cookie(c_id,c_name,c_price) values(?,?,?)");
			ps.setString(1, c.getCookieId());
			ps.setString(2, c.getCookieName());
			ps.setString(3, c.getCookiePrice());
			int i=ps.executeUpdate();
			
			if(i==1)
			{
				j=true;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return j;
		
		
		
	}
	
	
	public ArrayList<Cookie> selectCookieDetails()
	{
		Cookie c=null;
		ArrayList<Cookie> al=new ArrayList<Cookie>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from cookie");
			while(rs.next())
			{	
				c=new Cookie();
				c.setCookieId(rs.getString(1));
				c.setCookieName(rs.getString(2));
				c.setCookiePrice(rs.getString(3));
				
				
				al.add(c);
				
				
			}
			System.out.println(al);
			
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return al;
		
	}
	
	
	
	public boolean DeleteCookie(String id) {
		boolean m=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			 ps=con.prepareStatement("delete from cookie where c_id=?");
			ps.setString(1,id);
			int a=ps.executeUpdate();
			if(a==1) {
				m=true;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
		
		
		
	}
	
	
	public boolean updateCookie(Cookie cok,String id)
	{
		boolean l=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			ps=con.prepareStatement("update cookie set c_id=?,c_name=?,c_price=? where c_id=?");
			ps.setString(1,cok.getCookieId());
			ps.setString(2,cok.getCookieName());
			ps.setString(3,cok.getCookiePrice());
			
			ps.setString(4, id);
			
			int t=ps.executeUpdate();
			
			if(t==1) {
				l=true;
				
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}	
	
	
	
	
	
	

	
}
