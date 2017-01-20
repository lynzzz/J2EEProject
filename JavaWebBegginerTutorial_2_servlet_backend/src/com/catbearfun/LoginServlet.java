package com.catbearfun;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(
		
		description = "login Servlet",
		urlPatterns = {"/LoginServlet"},
		initParams = {
				@WebInitParam(name ="user", value="abc"),
				@WebInitParam(name ="password", value="abc")
		}
		
		
		)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		
		// getServletConfig().getInitParameter()     gets you variables @WebServlet defined in this file.
		// getServletContext().getinitPArameter()    returns you variables defined in web.xml
		if ( user.equals(getServletConfig().getInitParameter("user")) && 
			 pass.equals(getServletConfig().getInitParameter("password")) &&
			 getServletContext().getInitParameter("dbpath").equals("jdbc:mysql://localhost/mysql_db")
			){
			response.sendRedirect("success.jsp");
		}else{
			response.getWriter().println("<font color=red>Either user name or password is incorrect</font>");
		    getServletContext().getRequestDispatcher("/login.html").include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
