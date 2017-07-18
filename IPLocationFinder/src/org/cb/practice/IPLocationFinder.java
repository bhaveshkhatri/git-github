package org.cb.practice;

import net.webservicex.Country;
import net.webservicex.CountrySoap;
import net.webservicex.GetCountries;
import net.webservicex.GetCountriesResponse;

public class IPLocationFinder {

	public static void main(String[] args) {
		/*
		if(args.length!=1) {
			System.out.println("Please enter an IP address");
		}
		else {*/
			
			String CountryName = "INDIA";
			
			Country country = new Country();
			CountrySoap countrySoap = country.getCountrySoap();
			
			String cs = countrySoap.getCountries();
			
					
					//getCountryByCountryCode("in");
					
					//getISOCountryCodeByCountyName(CountryName);
			
			System.out.println(cs);
		//}

	}

}
