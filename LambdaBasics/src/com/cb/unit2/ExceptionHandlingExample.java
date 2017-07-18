package com.cb.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {

	public static void main(String[] args) {
		
		int[] someNumbers = {1, 2, 3, 4, 5};
		int key = 1;
		
		process(someNumbers, key, wrapperLambda((x, y) -> System.out.println(x/y)));
	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
		for (int i : someNumbers) {
			consumer.accept(i, key);
		}		
	}
	
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer,Integer> consumer) {
		
		return (v, k) -> {
			try {
			consumer.accept(v, k);
			}
			catch(Exception e) {
				System.out.println("Exception occured");
			
		}
		
	};
	}
}