package com.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DatabaseConnection.ConnectionFactory;

import com.revature.Dao.BeverageDao;
import com.revature.Model.Beverage;



@WebServlet("/DisplayBeverageServlet")
public class DisplayBeverageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DisplayBeverageServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BeverageDao ad=new BeverageDao(ConnectionFactory.getConnection());
		ArrayList<Beverage> al=ad.selectBeverageDetails();
		for(Beverage b:al)
		{
			System.out.println(b);
		}
		request.setAttribute("data", al);
		request.getRequestDispatcher("BeverageOperation.jsp").forward(request, response);
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
