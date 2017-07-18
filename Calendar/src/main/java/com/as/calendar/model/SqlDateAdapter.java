package com.as.calendar.model;

import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class SqlDateAdapter extends XmlAdapter<java.util.Date, java.sql.Date> {

	@Override
	public Date marshal(java.sql.Date sDate) throws Exception {
		if(null == sDate) {
            return null;
        }
		return new java.util.Date(sDate.getTime());
	}

	@Override
	public java.sql.Date unmarshal(Date uDate) throws Exception {
		if(null == uDate) {
            return null;
        }
		return new java.sql.Date(uDate.getTime());
	}
	
	

}
