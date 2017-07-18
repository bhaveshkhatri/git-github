package com.cb.practice;

import java.util.Random;

public class Station implements Runnable {

	private String name;
	private Pipe inPipe;
	private Pipe outPipe;
	private int workLoad;
	
	
	public Station(String name, int workload, Pipe inPipe, Pipe outPipe) {
		
		this.name = name;
		this.workLoad = workload;
		this.inPipe = inPipe;
		this.outPipe = outPipe;
		System.out.println(this.name+": IN connection set to "+this.inPipe.getName());
		System.out.println(this.name+": OUT connection set to "+this.outPipe.getName());
		System.out.println(this.name+": work load set to "+this.workLoad);
	}
	
	public void rest() {
		
		Random random = new Random();
		int seconds = random.nextInt(5)+3;
		
		try{
			
			wait();
			//Thread.sleep(10L);
			/*
			for(int i=seconds; i>0; i++) {
				//Thread.sleep(1000L);
			}*/
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void doWork() {
		System.out.println("i m working");
		Thread t = new Thread(this);
		t.start();
	}
	
	
	
	@Override
	public void run() {
		System.out.println("in run");
		while(workLoad > 0) {
			System.out.println("in run while");
			rest();
			System.out.println("in run while after rest");	
			while(!inPipe.isAvailable()) { 
				
			}			
			inPipe.setAvailable(false);
			System.out.println(name+": Granted access to "+inPipe.getName());
			
			
			
			while(!outPipe.isAvailable()) {
				
			}			
			outPipe.setAvailable(false);
			System.out.println(name+": Granted access to "+outPipe.getName());
			
			System.out.println(name+": successfully flows on "+inPipe.getName());
			System.out.println(name+": successfully flows on "+outPipe.getName());
			
			notify();
			
			inPipe.setAvailable(true);
			System.out.println(name+": Released access to "+inPipe.getName());
			
			outPipe.setAvailable(true);
			System.out.println(name+": Released access to "+outPipe.getName());
			
			workLoad--;			
		}
		System.out.println("******"+name+" Work load successfully completed *****");
		
	}
	
}

