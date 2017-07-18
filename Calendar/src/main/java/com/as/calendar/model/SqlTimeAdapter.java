package com.as.calendar.model;

import java.sql.Time;
import java.time.Clock;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class SqlTimeAdapter extends XmlAdapter<java.util.Date, java.sql.Time> {

	@Override
	public Date marshal(Time sTime) throws Exception {
		if(null == sTime) {
            return null;
        }
		return new java.util.Date(sTime.getTime());
	}

	@Override
	public Time unmarshal(Date uDate) throws Exception {
		if(null == uDate) {
            return null;
        }
		return new java.sql.Time(uDate.getTime());
	}

	
}
