package com.cb.Assignments;

import java.util.Scanner;

public class PerimeterOfASquare {

	static Scanner s = new Scanner(System.in);
	public static void main(String args[]) {
		
		System.out.print("Please enter the area of a square: ");
		double area = s.nextInt();
		double side = Math.sqrt(area);
		double perimeter  = 4 * side;
		System.out.println("The perimeter of the square is: "+perimeter);
	}
}
