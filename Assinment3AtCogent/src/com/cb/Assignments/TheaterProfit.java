package com.cb.Assignments;

import java.util.Scanner;

public class TheaterProfit {

	static Scanner s = new Scanner(System.in);
	static int performanceCost = 20;
	static double attndeeCost = 0.50;
	static int ticket = 5;

	public static void main(String[] args) {
		
		System.out.print("Please enter the number of attendees: ");
		int numOfAttendees = s.nextInt();
		
		totalProfit(ticket, numOfAttendees);

	}

	private static void totalProfit(int ticket2, int numOfAttendees) {
		
		int income = ticket2*numOfAttendees;
		
		double profit = income - (performanceCost + (numOfAttendees*attndeeCost));
		
		System.out.println("The Total Income of the theater is: "+income);
		
		if(profit<0) 
			System.out.println("The Total Loss of the theater is: "+profit);
				
		else 
			System.out.println("The Total Profit of the theater is: "+profit);
				
	}

}
