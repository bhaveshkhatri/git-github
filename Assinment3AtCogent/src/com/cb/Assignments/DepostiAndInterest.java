package com.cb.Assignments;

import java.util.Scanner;

public class DepostiAndInterest {

	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.print("Please enter the amount of deposit: ");
		int deposit = s.nextInt();
		double interest = 0;
		System.out.print("The amount of interest the deposit amount earns in an year: ");
		if(deposit <= 1000) {
			interest = (4 * deposit) / 100;
		}
		
		else if(deposit <= 5000) {
			interest = (4.5 * deposit) / 100;
		}
		
		else if(deposit > 5000) {
			interest = (5 * deposit) / 100;
		}
		
		System.out.println(interest);

	}

}
