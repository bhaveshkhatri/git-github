package com.cb.Assignments;

import java.util.Scanner;

public class PayBack {
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Please enter the amount charged: ");
		int amountCharged = s.nextInt();
		double payback = 0, register = 0;
		if(amountCharged<=500) {
			payback = amountCharged * 0.25 /100;
		}
		else if(amountCharged <= 1500) {
			payback = 1.25;
			register = amountCharged-500;
			payback += register * 0.5 /100;
		}
		else if(amountCharged <= 2500) {
			payback = 6.25;
			register = amountCharged - 1500;
			payback += register * 0.75/100;
		}
		else if(amountCharged > 2500) {
			payback = 13.75;
			register = amountCharged - 2500;
			payback += register * 0.75/100;
		}
		
		System.out.println(payback);

	}

}
