package com.exam;

import java.io.BufferedReader;
import java.io.FileReader;

public class CaleculateAmount {

	static int i=0, sum = 0;
	static int[] numbers = new int[10];
	public static void main(String[] args) {

		FileReader fr;
		BufferedReader br;
		String y = null, p = null;
		
		try {
			fr = new FileReader("src/com/exam/Sample file.txt");			
			br = new BufferedReader(fr);
			
			StringBuilder sb = new StringBuilder();
			String s; //
			int j = 0;
			while((s=br.readLine()) != null) {

			for(i=24; i<42; i++) {
				sb.append(s.charAt(i));			
			}
			y = sb.toString();
			sb = new StringBuilder();
			y = y.trim();			
			numbers[j] = Integer.parseInt(y);
			j++;
			
			for(i=59; i<61; i++) {
				sb.append(s.charAt(i));
			}
			y = sb.toString();
			sb = new StringBuilder();
			
			if(!(y.equalsIgnoreCase(p)) && p != null) System.out.println();
			System.out.println(s);			
			p = y;		
			
			}
						
			for(i=0; i<numbers.length; i++) {

			sum += numbers[i];
			}
			System.out.println("\n\nThe toal of the amounts is: "+sum);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

}
}
