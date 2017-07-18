package com.cb.cogent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

	public static void main(String[] args) {

		List<String> empNames = Arrays.asList("chirag", "tejasvi", "prasad", "sravya");
		Collections.sort(empNames, new Comparator<String>() {

			@Override
			public int compare(String a, String b) {
				
				return a.compareTo(b);
			}
			
		});
		
		Collections.sort(empNames, (String a, String b) -> {return a.compareTo(b);});
		System.out.println(empNames);
		
		empNames.sort(Collections.reverseOrder());
		System.out.println(empNames);
		
		List<String> empNames2 = Arrays.asList("chirag", "tejasvi", "prasad", "sravya");
		empNames2.sort(Comparator.nullsLast(String::compareTo));
		System.out.println(empNames2);
		
	}
	

}

