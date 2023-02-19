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
import com.revature.Model.Pizza;


@WebServlet("/AddPizzaServlet")
public class AddPizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddPizzaServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	int a=Integer.parseInt(request.getParameter("pizzaId"));
	String b=request.getParameter("pizzaname");
	String c=request.getParameter("Size");
	String d=request.getParameter("check");
	int e=Integer.parseInt(request.getParameter("res_code"));
	//System.out.println(a+b+c+d);
	Pizza piz=new Pizza(a, b, c, d,e);
	AdminDao ad=new AdminDao(ConnectionFactory.getConnection());
	boolean z=ad.AddPizzaDetails(piz);
	HttpSession h=request.getSession();
	if(z)
	{
		h.setAttribute("succMsg", "Added Pizza Successfully");
		response.sendRedirect("index_pizza.jsp");	
	}
	else
	{
		h.setAttribute("errorMsg", "Failed to add Pizza");
		response.sendRedirect("index_pizza.jsp");
	}
			
			
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
