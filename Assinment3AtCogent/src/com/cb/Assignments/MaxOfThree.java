package com.cb.Assignments;

import java.util.Scanner;

public class MaxOfThree {

	public static void main(String[] args) {

		int[] numbers = new int[3]; int i, j, temp;
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter three numbers as you wish ");
		
		for(i=0; i<3; i++) 
			numbers[i] = s.nextInt();
		
		for(i=0; i<3; i++) {
			for(j=1; j<3-i; j++) {
				
				if(numbers[j-1]>numbers[j]) {
					temp = numbers[j-1];
					numbers[j-1] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		
		 
		System.out.println("The maximum of given three numbers is: "+numbers[2]);	
		
			
	}

}
