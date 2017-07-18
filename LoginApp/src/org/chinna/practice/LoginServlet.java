package org.chinna.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.chinna.services.DataConnection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username, password;
		username = request.getParameter("loginid");
		password = request.getParameter("pwd");
		
		PrintWriter p = response.getWriter();
		p.print(username+"   "+password);
		
		DataConnection d = new DataConnection();
		boolean x = d.validate(username, password);
		if(x==false) 
			response.sendRedirect("login.jsp");
		else
			response.sendRedirect("home.jsp");
		
	}

}
