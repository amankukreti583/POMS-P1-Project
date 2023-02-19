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
import com.revature.Dao.AdminDao;
import com.revature.Dao.BeverageDao;
import com.revature.Model.Beverage;


@WebServlet("/DeleteBeverageServlet")
public class DeleteBeverageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteBeverageServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BeverageDao ad= new BeverageDao(ConnectionFactory.getConnection());
		int v=Integer.parseInt(request.getParameter("bz_id"));
		boolean s=ad.DeleteBeverage(v);
		HttpSession h=request.getSession();
		
		if(s)
		{
			h.setAttribute("success", "Beverage Deleted successfully");
			ArrayList<Beverage> al=ad.selectBeverageDetails();
			request.setAttribute("data", al);
			request.getRequestDispatcher("BeverageOperation.jsp").forward(request, response);
		}
		else {
			h.setAttribute("failure", "coudn't delete beverage");
			response.sendRedirect("BeverageOperation.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
