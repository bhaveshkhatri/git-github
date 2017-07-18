package com.cb.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw = response.getWriter();
		
		 HttpSession s = request.getSession();
		 String id = (String) s.getAttribute("id");
		 s.invalidate();
		 pw.println("<html>"
				 	+"<script type='text/javascript'>"
			        +"window.history.forward();"
			        +"function noBack()"
			        +"{window.history.forward();}</script>"
			
					+"<body onLoad='noBack();' onpageshow='if (event.persisted) noBack();' onUnload=''>"
					+"<h1>HHHello there!!!!! </h1><a href='logout.jsp'>Logout!</a></body></html>");
		/*pw.println("<h1>HHHello there!!!!! </h1>"+id);
		pw.println("<a href='logout.jsp'>Logout!</a>");*/
		
		
	}

}
