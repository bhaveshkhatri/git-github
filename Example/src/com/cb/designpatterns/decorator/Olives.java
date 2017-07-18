package com.cb.designpatterns.decorator;

public class Olives extends Toppings {
	
	Pizza pizza;
	public Olives(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String message() {
		
		return pizza.message()+" olives";
	}
	
	
}
