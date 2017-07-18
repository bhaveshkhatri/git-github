package com.cb.unit1;

public class TypeInferenceExample {

	public static void main(String[] args) {
		
		StringLengthLambda myLabda = s -> s.length();
		System.out.println(myLabda.getLength("Hello World"));
		
		printLambda(myLabda);
	}
	
	public static void printLambda(StringLengthLambda l) {
		System.out.println(l.getLength("Hello World"));
	}
	

}

interface StringLengthLambda {
	int getLength(String s);
}
