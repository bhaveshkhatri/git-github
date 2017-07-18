package com.cb.designpatterns.decorator;

public class CrabMasala extends Toppings {

	Pizza pizza;
	
	public CrabMasala(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String message() {
		
		return pizza.message()+" with crab masala";
	}
	
	
	
}
