package com.cb.Assignments;

import java.util.Scanner;

public class AmountOfTax {

	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
	
		System.out.print("Please enter the gross pay: ");
		int grossPay = s.nextInt();
		double tax=0;
	
		if(grossPay <= 240) tax = 0;
		else if(grossPay>240 && grossPay<=480) tax = (15 * grossPay) / 100;
		else if(grossPay>480) tax = (28 * grossPay) / 100;
		
		System.out.println("The tax rate is: "+tax);

	}

}
