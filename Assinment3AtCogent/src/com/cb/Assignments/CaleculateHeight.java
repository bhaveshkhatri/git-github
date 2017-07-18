package com.cb.Assignments;

import java.util.Scanner;

public class CaleculateHeight {

	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.print("Please enter the time in seconds: ");
		int t = s.nextInt();
		
		System.out.print("Please enter the rate of accelaration: ");
		int g = s.nextInt();
		
		int v = g * t;
		
		double height = 0.5 * v * t;
		
		System.out.println("The height that the rocket reaches in "+t+" seconds is: "+height);

	}

}
