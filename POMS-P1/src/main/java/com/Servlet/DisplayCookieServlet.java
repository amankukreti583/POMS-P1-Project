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
import com.revature.Dao.CookieDao;
import com.revature.Model.Cookie;
import com.revature.Model.Pizza;


@WebServlet("/DisplayCookieServlet")
public class DisplayCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DisplayCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CookieDao ad=new CookieDao(ConnectionFactory.getConnection());
		ArrayList<Cookie> al=ad.selectCookieDetails();
		request.setAttribute("data", al);
		request.getRequestDispatcher("CookieOperation.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
