package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DatabaseConnection.ConnectionFactory;
import com.revature.Dao.AdminDao;
import com.revature.Model.AdminModel;


@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		String u=request.getParameter("email");
		String p=request.getParameter("pass");
	
		
		AdminModel b=new AdminModel(u, p);
		AdminDao d=new AdminDao(ConnectionFactory.getConnection());
		boolean bool=d.checkLogin(b);
		HttpSession h=request.getSession();
		if(bool)
		{
				
			response.sendRedirect("LandingPage.jsp");	
		}
		else
		{
			h.setAttribute("errorMsg", "Wrong Admin Credentials");
			response.sendRedirect("AdminIndex.jsp");
		}
	}


	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
