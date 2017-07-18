package com.cb.unit1;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Example {
	
	public void display(Greeting greetings) {
		greetings.greet();
	}
	
	public static void main(String[] args) {
		
		Greeting grettings = new HelloWorld();
		Example e = new Example();
		//e.display(grettings);
		
		
		//Greeting myLambdaMehtod = () -> System.out.println("This is lambda!!");
		
		Greeting gretter = new Greeting() {
			
			public void greet() {
				System.out.println("Hello");
			}
		};
		
		e.display(grettings);
		e.display(() -> System.out.println("This is lambda!!"));
		
		 
	}
	
	
	
	
}