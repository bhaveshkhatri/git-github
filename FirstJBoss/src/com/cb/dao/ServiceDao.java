package com.cb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceDao {
	
	Connection connection = null;
	String connectionUrl = "jdbc:mysql://localhost:3306/hibernatedb";
	String User = "root";
	String Password = "root";
	
	
	
	public Connection getConnectionn() {
	
		if(connection != null) {
			return connection;
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(connectionUrl, User, Password);
			return connection;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return connection;
	}
	
	public int registerUser(String name, String acc, String pwd, String email, String country) throws ClassNotFoundException {
		
		String sql = "insert into accounts(accountno, name, email,  password, country) values(?, ?, ?, ?, ?)";
		
		try {			
			PreparedStatement pst = getConnectionn().prepareStatement(sql);
			
			pst.setString(1, name);
			pst.setString(2, acc);
			pst.setString(3, pwd);
			pst.setString(4, email);
			pst.setString(5, country);
			
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}

	public boolean login(String loginid, String pwd) {
		
		String sql = "select *from mytable where email=? and password=?";// where email=? and password=?";
		
		try {
			/*Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernatedb", "root", "root");*/
			
			PreparedStatement pst = getConnectionn().prepareStatement(sql);
			pst.setString(1, loginid);
			pst.setString(2, pwd);
			ResultSet rs = pst.executeQuery();
			
			boolean f = rs.next();
			System.out.println("job "+f);
			return f;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
