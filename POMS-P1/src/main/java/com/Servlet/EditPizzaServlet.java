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


@WebServlet("/EditPizzaServlet")
public class EditPizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditPizzaServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int p1=Integer.parseInt(request.getParameter("id"));
		String p2=request.getParameter("name");
		String p3=request.getParameter("size");
		String p4=request.getParameter("category");
		int p5=Integer.parseInt(request.getParameter("price"));
		
		
		AdminDao ad= new AdminDao(ConnectionFactory.getConnection());
		Pizza piz=new Pizza(p1, p2, p3, p4, p5);
		ad.updatePizza(piz, p1);
		ArrayList<Pizza> al=ad.selectPizzaDetails();
		request.setAttribute("data", al);
		request.getRequestDispatcher("PizzaOperations.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
