package com.cb.Assignments;

import java.util.Scanner;

public class SumsAndSquares {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		int n = s.nextInt();
		int sumOfSquares=0, squareOfSums=0, i, sum=0;
		for(i=1;i<=n;i++) { 
			sum += i;
			sumOfSquares += i*i;
		}
		squareOfSums = sum*sum;
		
		System.out.println("the difference between sum of the squares and the square of the sums of "+n+" numbers is: "+(squareOfSums-sumOfSquares)); 
			
		
		
		

	}

}
