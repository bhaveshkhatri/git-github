package com.as.calendar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.glassfish.jersey.internal.util.collection.Settable;

import com.as.calendar.model.Appointment;

public class AppointmentsDao {
	
	Connection connection = null;
	String connectionUrl = "jdbc:mysql://localhost:3306/hibernatedb";
	String User = "root";
	String Password = "root";
	
	public Connection getConnection() {
		
		if(connection != null) {
			return connection;
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(connectionUrl, User, Password);
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	
	}

	public List<Appointment> getAppointments() {
	
		List<Appointment> appointments = new ArrayList<Appointment>();
		
		String sql = "select *from appointments";
		
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Appointment a = new Appointment();		
				a.setAid(rs.getInt(1));
				a.setAdate(rs.getDate(2));
				a.setAtime(rs.getTime(3));
				a.setAsubject(rs.getString(4));
				a.setAnotes(rs.getString(5));
				a.setPname(rs.getString(6));
				
				appointments.add(a);
				
				System.out.println(rs.getInt(1)+" "+" "+rs.getDate(2)+" "+rs.getTime(3)+" "+rs.getString(4)+" "+rs.getString(5));
			}
			//System.out.println(appointments);
			return appointments;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public int addAppointment(Appointment appointment) {
		
		String sql = "insert into appointments(adate, atime, asubject, anotes, pname) values(?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setDate(1, appointment.getAdate());
			pst.setTime(2, appointment.getAtime());
			pst.setString(3, appointment.getAsubject());
			pst.setString(4, appointment.getAnotes());
			pst.setString(5, appointment.getPname());
			return pst.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	
		
		
	}

	public int updateAppointment(int aid, Appointment appointment) {
		
		String sql = "update appointments set adate=?, atime=?, asubject=?, anotes=?, pname=? where aid=?;";
		
		try {
			
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setDate(1, appointment.getAdate());
			pst.setTime(2, appointment.getAtime());
			pst.setString(3, appointment.getAsubject());
			pst.setString(4, appointment.getAnotes());
			pst.setString(5, appointment.getPname());
			pst.setInt(6, aid);
			
			return pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public boolean deleteAppointment(int aid) {
		
		String sql = "delete from appointments where aid=?;";
		
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setInt(1, aid);
			boolean flag = pst.execute();
			System.out.println(flag);
			return flag;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
