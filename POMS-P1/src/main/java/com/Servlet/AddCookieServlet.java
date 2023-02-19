package com.Servlet;

import java.io.IOException;
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


@WebServlet("/AddCookieServlet")
public class AddCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String a=request.getParameter("cid");
		String b=request.getParameter("cname");
		String c=request.getParameter("cprice");
		
		//System.out.println(a+b+c);
		Cookie cok= new Cookie(a, b, c);
		CookieDao ad=new CookieDao(ConnectionFactory.getConnection());
		boolean z=ad.AddCookieDetails(cok);
		HttpSession h=request.getSession();
		if(z)
		{
			h.setAttribute("succMsg", "Added Cookie Successfully");
			response.sendRedirect("index_cookie.jsp");	
		}
		else
		{
			h.setAttribute("errorMsg", "Failed to add Cookie");
			response.sendRedirect("index_cookie.jsp");
		}
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
