package com.Servlet;

import java.io.IOException;
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
import com.revature.Model.Pizza;


@WebServlet("/AddBeverageServlet")
public class AddBeverageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddBeverageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a=request.getParameter("bid");
		String b=request.getParameter("bname");
		String c=request.getParameter("btype");
		String d=request.getParameter("bprice");
		System.out.println(a+b+c+d);
		Beverage bev= new Beverage(a, b, c, d);
		BeverageDao ad=new BeverageDao(ConnectionFactory.getConnection());
		boolean z=ad.AddBeverageDetails(bev);
		HttpSession h=request.getSession();
		if(z)
		{
			h.setAttribute("succMsg", "Added Beverage Successfully");
			response.sendRedirect("index_beverage.jsp");	
		}
		else
		{
			h.setAttribute("errorMsg", "Failed to add Beverage");
			response.sendRedirect("index_beverage.jsp");
		}
				
				
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
