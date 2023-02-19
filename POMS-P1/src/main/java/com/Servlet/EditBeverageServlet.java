package com.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DatabaseConnection.ConnectionFactory;
import com.revature.Dao.AdminDao;
import com.revature.Dao.BeverageDao;
import com.revature.Model.Beverage;
import com.revature.Model.Pizza;


@WebServlet("/EditBeverageServlet")
public class EditBeverageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EditBeverageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p1=request.getParameter("id");
		String p2=request.getParameter("name");
		String p3=request.getParameter("type");
		String p4=request.getParameter("price");
		
		
		
		BeverageDao ad= new BeverageDao(ConnectionFactory.getConnection());
		Beverage bev=new Beverage(p1, p2, p3, p4);
		ad.updateBeverage(bev, p1);
		ArrayList<Beverage> al=ad.selectBeverageDetails();
		request.setAttribute("data", al);
		request.getRequestDispatcher("BeverageOperation.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
