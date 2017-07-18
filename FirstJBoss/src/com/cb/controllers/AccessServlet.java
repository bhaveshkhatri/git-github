package com.cb.controllers;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cb.dao.ServiceDao;

import jdk.nashorn.internal.runtime.RewriteException;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class AccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    ServiceDao serve = new ServiceDao();
    PrintWriter pw = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 pw = response.getWriter();
		
		pw.println("Chinna");
		
		String name = request.getParameter("id");
		String accno = request.getParameter("acc");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		try {
			int i = serve.registerUser(name, accno, pwd, email, country);
			
			if(i<1) {
				pw.println("<h3>OHhh!!  Please enter correct credentials.....</h3>");
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.include(request, response);		
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);		
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		pw = response.getWriter();
		String loginid = request.getParameter("id");
		String pwd = request.getParameter("pwd");		
		boolean flag = true;
		flag = serve.login(loginid, pwd);
		
		HttpSession s = request.getSession();
		s.setAttribute("id", loginid);
		if(flag == false) {
			pw.println("<h1>Login failed... Please try again!</h1>");	
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.include(request, response);		
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("home");
			rd.forward(request, response);
		}
		
	}

}




