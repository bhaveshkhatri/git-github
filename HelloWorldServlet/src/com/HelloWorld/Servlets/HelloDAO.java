package com.HelloWorld.Servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloDAO {
	
	
	public static boolean login(String loginID, String pwd) throws SQLException {
		
		System.out.println("i am in HElloDAO");
		
		Connection con;
		ResultSet rs;
		PreparedStatement pst;
		boolean status=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			pst = con.prepareStatement("Select *from login where loginID=? and passWord=?");
			pst.setString(1, loginID);
			pst.setString(2, pwd);
			rs = pst.executeQuery();
			status = rs.next();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return status;
	}
	

}
