package com.cb.Assignments;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

public class IsItVowel {

	public static char[] vowels = {'a', 'e', 'i', 'o' ,'u'};
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the character: ");
		String vowel = "aeiou";
		
		CharSequence c = s.next();
		
		
		if(vowel.contains(c))
			System.out.println("The given character is a vowel");
		else System.out.println("The given character is not a vowel");
		

	}

}
