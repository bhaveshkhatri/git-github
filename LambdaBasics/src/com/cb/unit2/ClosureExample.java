package com.cb.unit2;

public class ClosureExample {

	public static void main(String[] args) {
		
		int i = 10;
		int j = 20;
		
		doProcess(i, x -> System.out.println(x + j));

	}
	
	public static void doProcess(int i, Process p) {
		p.process(i);
	}

}

interface Process{
	public void process(int i);
}