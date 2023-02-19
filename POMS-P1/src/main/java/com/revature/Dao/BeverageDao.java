package com.revature.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.Model.Beverage;




public class BeverageDao {
	
	
	private Connection conn;

	public BeverageDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	
	String url="jdbc:mysql://localhost:3306/poms";
	String username="root";
	String password="Alapino583@";
	Connection con=null;
	Statement st=null;
	PreparedStatement ps=null;
	
	public boolean AddBeverageDetails(Beverage bev)
	{
		boolean j=false;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			ps=con.prepareStatement("insert into beverage(b_id,b_name,b_type,b_price) values(?,?,?,?)");
			ps.setString(1, bev.getBeverageId());
			ps.setString(2, bev.getBeverageName());
			ps.setString(3, bev.getBeverageType());
			ps.setString(4, bev.getBeveragePrice());
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
	
	
	
	
	public ArrayList<Beverage> selectBeverageDetails()
	{
		Beverage b=null;
		ArrayList<Beverage> al=new ArrayList<Beverage>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from beverage");
			while(rs.next())
			{	
				b=new Beverage();
				b.setBeverageId(rs.getString(1));
				b.setBeverageName(rs.getString(2));
				b.setBeverageType(rs.getString(3));
				b.setBeveragePrice(rs.getString(4));
				
				
				al.add(b);
				
				
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
	
	public boolean DeleteBeverage(int id) {
		boolean m=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			 ps=con.prepareStatement("delete from beverage where b_id=?");
			ps.setInt(1,id);
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
	public boolean updateBeverage(Beverage bev,String id)
	{
		boolean l=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			ps=con.prepareStatement("update beverage set b_id=?,b_name=?,b_type=?,b_price=? where b_id=?");
			ps.setString(1,bev.getBeverageId());
			ps.setString(2,bev.getBeverageName());
			ps.setString(3,bev.getBeverageType());
			ps.setString(4,bev.getBeveragePrice());
			
			ps.setString(5, id);
			
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
