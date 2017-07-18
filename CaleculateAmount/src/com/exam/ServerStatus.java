package com.exam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ServerStatus {

	
	static String s = null;
	static int x, y;
	public static void main(String[] args) throws IOException, InterruptedException {
		
		FileReader fr;
		BufferedReader br;
		
		try {
			fr = new FileReader("src/com/exam/SERVER_STATUS.txt");			
			br = new BufferedReader(fr);
			

			
			while((s = br.readLine()) != null) {
			
				x = Integer.parseInt(String.valueOf(s.charAt(4)));
				s = br.readLine();
				y = Integer.parseInt(String.valueOf(s.charAt(4)));
				System.out.println(x+"   "+y);
				
				if((x == 2) || (x == 3)) System.out.println("RED Alert for IVR");
				else
				if(x == 1) System.out.println("AMBER Alert for IVR");
				
				if((y == 2) || (y == 3)) System.out.println("RED Alert for EBS");
				else
				if(y == 1) System.out.println("AMBER Alert for EBS");
				
				if(x == 0 && y == 0) System.out.println("NO Alert");
				System.out.println("\n");
				Thread.sleep(2000);
				
			}
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}		

}

}
