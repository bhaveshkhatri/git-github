package com.as.calendar.model;



import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Time;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Appointment {

	private int aid;
	
	@XmlJavaTypeAdapter(SqlDateAdapter.class)
	private Date adate;
	
	@XmlJavaTypeAdapter(SqlTimeAdapter.class)
	private Time atime;
	
	private String asubject;
	private String anotes;
	private String pname;

	
	public Appointment() {
		
	}

	public Appointment(int aid, Date adate,Time atime, String asubject, String anotes, String pname) {
		super();
		this.aid = aid;
		this.adate = adate;
		this.atime = atime;
		this.asubject = asubject;
		this.anotes = anotes;
		this.pname = pname;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Date getAdate() {
		return adate;
	}

	public void setAdate(Date adate) {
		this.adate = adate;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public Time getAtime() {
		return atime;
	}

	public void setAtime(Time atime) {
		this.atime = atime;
	}

	public String getAsubject() {
		return asubject;
	}

	public void setAsubject(String asubject) {
		this.asubject = asubject;
	}

	public String getAnotes() {
		return anotes;
	}

	public void setAnotes(String anotes) {
		this.anotes = anotes;
	}

}
