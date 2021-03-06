package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JDBCTest {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernatedb","root","root");
		Statement stmt = con.createStatement();
		//stmt.execute("create table mine(eid numeric, ename varchar(20), esal numeric, primary key(eid))");
		//stmt.execute("insert into mine values(1, 'chinna', 5000)");
		/*stmt.execute("insert into mine values(2, 'ram', 6000)");
		stmt.execute("insert into mine values(3, 'venkey', 8000)");
		stmt.execute("insert into mine values(4, 'padma', 10000)");*/
		//String sql = "select *from mine";
		/*ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					System.out.println(rs.getInt(0)+" "+rs.getString(1)+" "+rs.getInt(2));
				}*/

		
		CallableStatement cst = con.prepareCall("{call findMe(?)}"); 
		cst.setInt(1, 2);
		ResultSet rs = cst.executeQuery();
		while(rs.next()) { 
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
		
		
	}

}
