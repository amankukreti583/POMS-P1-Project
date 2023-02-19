package com.revature.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.Model.AdminModel;
import com.revature.Model.Pizza;

public class AdminDao {
	
	private Connection conn;

	public AdminDao(Connection conn) {
		super();
		this.conn = conn;
	}


	String url="jdbc:mysql://localhost:3306/poms";
	String username="root";
	String password="Alapino583@";
	Connection con=null;
	Statement st=null;
	PreparedStatement ps=null;
	
	
	public boolean checkLogin(AdminModel b)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from admin");
			while(rs.next())
			{
				String demail=rs.getString(1);
				String dpassword=rs.getString(2);
				if(demail.equals(b.getEmail())&& dpassword.equals(b.getPassword()))
				{
					return true;
				}
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false;
		
	}
	
	
	public boolean AddPizzaDetails(Pizza piz)
	{
		boolean j=false;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			ps=con.prepareStatement("insert into pizza(pizza_id,pizza_type,pizza_size,pizza_category,pizza_price) values(?,?,?,?,?)");
			ps.setInt(1, piz.getPizzaId());
			ps.setString(2, piz.getPizzaType());
			ps.setString(3, piz.getPizzaSize());
			ps.setString(4, piz.getPizzaCategory());
			ps.setInt(5, piz.getPizzaPrice());
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
	
	
	public ArrayList<Pizza> selectPizzaDetails()
	{
		Pizza p=null;
		ArrayList<Pizza> al=new ArrayList<Pizza>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from pizza");
			while(rs.next())
			{	
				p=new Pizza();
				p.setPizzaId(Integer.parseInt(rs.getString(1)));
				p.setPizzaType(rs.getString(2));
				p.setPizzaSize(rs.getString(3));
				p.setPizzaCategory(rs.getString(4));
				p.setPizzaPrice(Integer.parseInt(rs.getString(5)));
				
				al.add(p);
				
				
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
	
	
	
	public boolean DeletePizza(int id) {
		boolean m=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			 ps=con.prepareStatement("delete from pizza where pizza_id=?");
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
	
	
	public boolean updatePizza(Pizza pizza,int id)
	{
		boolean l=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			ps=con.prepareStatement("update pizza set pizza_id=?,pizza_type=?,pizza_size=?,pizza_category=?,pizza_price=? where pizza_id=?");
			ps.setInt(1,pizza.getPizzaId());
			ps.setString(2,pizza.getPizzaType());
			ps.setString(3,pizza.getPizzaSize());
			ps.setString(4, pizza.getPizzaCategory());
			ps.setInt(5, pizza.getPizzaPrice());
			ps.setInt(6, id);
			
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
	
	
	
//	public Pizza getPizzabyId(int id)
//	{
//		Pizza piz=null;
//		String sql="select * from pizza where pizza_id=?";
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con=DriverManager.getConnection(url, username, password);
//			ps=con.prepareStatement(sql);
//			ps.setInt(1,id );
//			ResultSet rs=ps.executeQuery();
//			if(rs.next())
//			{
//				int q=rs.getInt(1);
//				String w=rs.getString(2);
//				String e=rs.getString(3);	
//				String r=rs.getString(4);
//				int t=rs.getInt(5);
//				piz=new Pizza(q, w, e, r, t);
//			}
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//			return piz;
//	}
	
	
	
	
	
}
