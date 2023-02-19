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
import com.revature.Model.Pizza;


@WebServlet("/DisplayPizzaServlet")
public class DisplayPizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DisplayPizzaServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminDao ad=new AdminDao(ConnectionFactory.getConnection());
		ArrayList<Pizza> al=ad.selectPizzaDetails();
		request.setAttribute("data", al);
		request.getRequestDispatcher("PizzaOperations.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
