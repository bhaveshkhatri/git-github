package com.cb.Assignments;

import java.util.Scanner;

public class BalanceAtEnd {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.print("Please enter the principal amount: ");
		double principal = s.nextInt();
		System.out.print("Please enter the anual interest rate: ");
		double interestRate = s.nextInt();
		System.out.print("Please enter the number of months: ");
		int months = s.nextInt();
		/*double yeaar = months * 0.08333;
		System.out.println(yeaar);*/
		double interest = principal * (interestRate/100) * (months*0.83333);// 
		//System.out.println(months);
		//double x = interest * (months*1/12);
		//System.out.println("The interest: "+x);
		
		double balance = principal + interest;
		
		System.out.println("The toal balance after "+months+" months is: "+balance);
		


	}

}
