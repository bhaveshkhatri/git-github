package com.cb.practice;

import java.util.Scanner;

public class Fibonacci {

	private static int i,n=10, n1=0, n2=1, f=1;
	
	public static void main(String args[]) {
		
		//System.out.println("Pelase enter a value to find the fibonacci of that number");
		
				
		System.out.print(n1+" "+n2);
		
		/*for(i=2;i<n;i++) {
			
			f = n1+n2;
			System.out.print(" "+f);
			n1=n2;
			n2=f;*/
		
		fibonacci(n-2);		
	}

	private static void fibonacci(int n3) {
		
		if(n3>0) {
			
			f = n1+n2;
			n1=n2;
			n2=f;
			System.out.print(" "+f);
			fibonacci(n3-1);
		}
		
	}


	
}
