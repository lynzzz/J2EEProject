package com.catbearfun;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCookieServlet
 */
@WebServlet("/LoginCookieServlet")
public class LoginCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final String user = "cat";
    private final String pass = "bear";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String htmlName = request.getParameter("userName");
		String htmlpass = request.getParameter("password");
		
		if ( htmlName.equals(user) && htmlpass.equals(pass)){
			Cookie ck = new Cookie( "cookieExample", "lyn");
			ck.setMaxAge(5*60);
			response.addCookie(ck);
			response.sendRedirect("LoginSuccess.jsp");
		}else{
			java.io.PrintWriter out = response.getWriter();
			out.println("Either the name or password is wrong");
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			rd.include(request, response);
		}	
	}
}
