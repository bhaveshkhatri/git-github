package com.cb.cogent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Vector;

public class CollectionTest {

	
	public static void main(String[] args) {

		String s = "bbcca";
		
		/*int[] a = {1, 2, 3, 4, 5};
		
		
		//SortedMapMap<Character, Integer> list = new TreeMap()
		int x = Arrays.binarySearch(a, 3);
		System.out.println(x);*/
		SortedMap<Character, Integer> list = new TreeMap<>();
		
		for(int i=0; i<s.length(); i++) {	
			list.put(s.charAt(i), 0);
		}
		
		System.out.println(list);
		
		if(list.containsValue(0)) {			
			for(Character k: list.keySet()) {
				if((list.get(k)) == 1) {
					System.out.println(k);
				}
			}
		}		
	}
}