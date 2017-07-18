package com.cb.cogent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.dbcp2.BasicDataSource;

public class Find   {
		
	
	
	public static void main(String[] args) {
		
		List<String> names = new ArrayList<String>();
		List<Date> dates = new ArrayList<>();
		
		names.add("chinna");
		names.add("ram");
		names.add("saran");
		names.add("padma");
		
		dates.add(new Date("03 April 2017"));
		dates.add(new Date("10 April 2017"));
		dates.add(new Date("20 April 2017"));
		dates.add(new Date("23 April 2017"));
		
		//System.out.println(dates);
		Date date;
		Scanner s = new Scanner(System.in);
		String given;
		String day = s.next();  String month = s.next();  String year = s.next();
		given = day+" "+month+" "+year;
		date = new Date(given);
		long now = date.getTime();
		
		/*Date closest = Collections.min(dates, new Comparator<Date>() {

			@Override
			public int compare(Date o1, Date o2) {
				long diff1 = Math.abs(o1.getTime()-now);
				long diff2 = Math.abs(o2.getTime()-now);
				return Long.compare(diff1, diff2);
			}		
			
		});*/
		
		
		// By using Lambda Expression
		Date closest1 = Collections.min(dates, (d1, d2) -> {
			
			long diff1 = Math.abs(d1.getTime()-now);
			long diff2 = Math.abs(d2.getTime()-now);
			return Long.compare(diff1, diff2);
		}
		
				
				
				);
		
		//System.out.println(closest);

	System.out.println(names.get(dates.indexOf(closest1)));
		
	}
	
	
	
}