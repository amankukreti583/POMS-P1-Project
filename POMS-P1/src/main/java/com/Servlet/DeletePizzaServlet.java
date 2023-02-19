package com.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DatabaseConnection.ConnectionFactory;
import com.mysql.cj.Session;
import com.revature.Dao.AdminDao;
import com.revature.Model.Pizza;


@WebServlet("/DeletePizzaServlet")
public class DeletePizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeletePizzaServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminDao ad= new AdminDao(ConnectionFactory.getConnection());
		int v=Integer.parseInt(request.getParameter("pz_id"));
		boolean s=ad.DeletePizza(v);
		HttpSession h=request.getSession();
		
		if(s)
		{
			h.setAttribute("success", "Pizza Deleted successfully");
			ArrayList<Pizza> al=ad.selectPizzaDetails();
			request.setAttribute("data", al);
			request.getRequestDispatcher("PizzaOperations.jsp").forward(request, response);
		}
		else {
			h.setAttribute("failure", "coudn't delete pizza");
			response.sendRedirect("PizzaOperations.jsp");
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
