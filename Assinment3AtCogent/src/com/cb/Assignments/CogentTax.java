package com.cb.Assignments;

import java.util.Scanner;

public class CogentTax {

	static Scanner s = new Scanner(System.in);
	static int taxRate = 15, hourlyRate = 12;
	public static void main(String[] args) {
		
		System.out.print("Please enter the number of hours worked: ");
		int hours = s.nextInt();
		int grossSalary = hours * hourlyRate;
		
		int tax = caleculateTax(grossSalary);
		caleculateNetPay(grossSalary, tax);

	}
	
	private static void caleculateNetPay(int grossSalary, int tax) {
		
		int netPay = grossSalary - tax;
		System.out.println("The net pay is: "+netPay);
		
	}
	private static int caleculateTax(int grossSalary) {
		System.out.println();
		System.out.println();
		System.out.print("The tax amount is: ");
		int tax = (grossSalary*taxRate) / 100;
		
		System.out.println(tax);
		return tax;
		
	}

}
