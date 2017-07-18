package com.cb.Assignments;

import java.util.Scanner;

public class Loan {
	
	public static Scanner s = new Scanner(System.in);
	
	public static void main(String args[]) {
		
		System.out.print("Please enter the age: ");
		int age = s.nextInt();
		System.out.print("Please enter the gender (Either M or F): ");
		String gender = s.next();
		System.out.print("Please enter the job status(Either self or professional): ");
		String jStatus = s.next();
		System.out.print("Please enter the assets: ");
		int assets = s.nextInt();
		int loanAmount=0;
		
		if(age>=16 && age<=25 && assets > 25000 && (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F"))) {
					
			if(jStatus.equalsIgnoreCase("self")) loanAmount=10000;
			else if(jStatus.equalsIgnoreCase("professional")) loanAmount=15000;
		} 
		
		else if(age>=26 && age<=40 && assets > 40000 && (jStatus.equalsIgnoreCase("self") || jStatus.equalsIgnoreCase("professional"))) {
			
			if(gender.equalsIgnoreCase("M"))	loanAmount=25000;
			else if(gender.equalsIgnoreCase("F")) loanAmount=30000;
		}
		
		else if(age>=41 && age<=60 && assets > 50000 && (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F")) &&(jStatus.equalsIgnoreCase("self") || jStatus.equalsIgnoreCase("professional"))) {
			
			loanAmount = 40000;
		}
		
		else if(age>60 && assets > 25000 && (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F"))) {
			
			if((jStatus.equalsIgnoreCase("self"))) loanAmount = 35000-(age*100);
			else if(jStatus.equalsIgnoreCase("retired")) loanAmount = 25000-(age*100);
		}
		
		else {
			System.out.println("You have enter incorrect credentials....");
		}
		
		System.out.println("The eligible loan amount is: "+loanAmount);
		
	}

}
