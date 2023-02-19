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
import com.revature.Dao.BeverageDao;
import com.revature.Dao.CookieDao;
import com.revature.Model.Beverage;
import com.revature.Model.Cookie;


@WebServlet("/DeleteCookieServlet")
public class DeleteCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
       public DeleteCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CookieDao ad= new CookieDao(ConnectionFactory.getConnection());
		String v=request.getParameter("cz_id");
		boolean s=ad.DeleteCookie(v);
		HttpSession h=request.getSession();
		
		if(s)
		{
			h.setAttribute("success", "Cookie Deleted successfully");
			ArrayList<Cookie> al=ad.selectCookieDetails();
			request.setAttribute("data", al);
			request.getRequestDispatcher("CookieOperation.jsp").forward(request, response);
		}
		else {
			h.setAttribute("failure", "coudn't delete cookie");
			response.sendRedirect("CookieOperation.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
