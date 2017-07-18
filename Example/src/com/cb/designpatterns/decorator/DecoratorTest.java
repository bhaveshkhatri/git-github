package com.cb.designpatterns.decorator;

public class DecoratorTest {

	public static void main(String[] args) {

		Pizza pizza = new Pizza();
		
		System.out.println(pizza.message());
		
		pizza = new Olives(pizza);
		System.out.println(pizza.message());
		
		pizza = new CrabMasala(pizza);
		System.out.println(pizza.message());
	}

}
