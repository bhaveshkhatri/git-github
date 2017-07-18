package com.cb.cipher;

import java.util.HashMap;
import java.util.Map;

public final class EncryptDecrypt {

	private static String encryptString, decryptString, key;
	private static Map<String, String> cache = new HashMap<>();
	private static int breakPoint = 0;

	// Method to decrypt a string which takes a string to be decrypted, with
	// even number of letters as an argument
	public static void decrypt(String decryptString) {
		breakPoint = 0;

		// Checking whether the string length is even or odd
		if (decryptString.length() % 2 != 0) {
			System.out.println("Sorry!, You have entered wrong format String");
			return;
		}

		System.out.println("Decrypting " + decryptString);

		// Searching for the string in the cache
		for (Object o : cache.keySet()) {
			if (cache.get(o).equals(decryptString)) {
				System.out.println(decryptString + " found in cache");
				System.out.println("Result is: " + o);
				breakPoint++;
				return;
			}
		}

		// The String with a '#' in the middle, which means the actual string
		// before decryption is of odd length
		if (decryptString.contains("#") && breakPoint == 0) {
			String[] parts = {
					decryptString.substring(0, decryptString.indexOf("#")),
					decryptString.substring(decryptString.indexOf("#") + 1) };

			encryptString = new StringBuilder(parts[1]).append(parts[0])
					.toString();
			System.out.println("adding to cache");
			cache.put(encryptString, decryptString);
			System.out.println("Result is: " + encryptString);
			return;
		}

		// If the string is of even length
		else if (breakPoint == 0) {
			String[] parts = {
					decryptString.substring(0, decryptString.length() / 2),
					decryptString.substring(decryptString.length() / 2) };
			encryptString = new StringBuilder(parts[1]).append(parts[0])
					.toString();
			System.out.println("adding to cache");
			cache.put(encryptString, decryptString);
			System.out.println("Result is: " + encryptString);
			return;
		}

	}

	// Method to encrypt a string, which takes a string as an argument to be
	// encrypted
	public static void encrypt(String encryptString) {

		key = encryptString;
		System.out.println("Encrypting: " + encryptString);

		// Checking weather the cache contains the string
		if (cache.containsKey(key)) {
			System.out.println(key + " found in cache");
			System.out.println("Result is: " + cache.get(key));
			return;
		}

		// Verifying the string is with odd or even number of letters
		if (encryptString.length() % 2 != 0)
			encryptString = encryptString.concat("#");

		String[] parts = {
				encryptString.substring(0, encryptString.length() / 2),
				encryptString.substring(encryptString.length() / 2) };

		decryptString = new StringBuilder(parts[1]).append(parts[0]).toString();

		try {
			System.out.println("Adding to cache");
			cache.put(key, decryptString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Result is: " + decryptString);
	}

}
