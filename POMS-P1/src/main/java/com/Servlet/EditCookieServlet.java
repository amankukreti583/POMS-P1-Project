package com.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DatabaseConnection.ConnectionFactory;

import com.revature.Dao.CookieDao;

import com.revature.Model.Cookie;


@WebServlet("/EditCookieServlet")
public class EditCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String p1=request.getParameter("id");
		String p2=request.getParameter("name");
		String p3=request.getParameter("price");
		
		
		
		CookieDao ad= new CookieDao(ConnectionFactory.getConnection());
		Cookie cok=new Cookie(p1, p2, p3);
		ad.updateCookie(cok, p1);
		ArrayList<Cookie> al=ad.selectCookieDetails();
		request.setAttribute("data", al);
		request.getRequestDispatcher("CookieOperation.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
