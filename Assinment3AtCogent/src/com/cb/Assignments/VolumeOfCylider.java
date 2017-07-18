package com.cb.Assignments;

import java.util.Scanner;

public class VolumeOfCylider {

	static Scanner s = new Scanner(System.in);
	static double pi = 3.14;
	public static void main(String[] args) {

		System.out.print("Please enter the value for radius of a cylinder's base disk: ");
		double radious = s.nextDouble();
		System.out.print("Please enter the value for height of a cylinder: ");
		double height = s.nextDouble();
		
		System.out.print("The area of a cylinder is: ");
		double area = pi * (radious*radious) * height;
		System.out.println(area);


	}

}
