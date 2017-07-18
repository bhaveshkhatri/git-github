package com.cb.cipher;

import java.security.acl.LastOwnerException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cipher {

	private static String choice;
	private static Scanner s = new Scanner(System.in);
	private static String encryptString, decryptString; // Inputs to encrypt and
														// decrypt

	public static void main(String[] args) {

		for (;;) {
			System.out
					.print("\nChose what you want to do!\nEncryption: E   Decryption: D  Exit: X\n->");

			choice = s.next();

			if (choice.equalsIgnoreCase("E")) {
				System.out.print("Enter the string to encrypt:  ");
				encryptString = s.next();
				EncryptDecrypt.encrypt(encryptString);
			} else if (choice.equalsIgnoreCase("D")) {
				System.out.print("Enter the sting to decrypt:  ");
				decryptString = s.next();
				EncryptDecrypt.decrypt(decryptString);
			} else if (choice.equalsIgnoreCase("X"))
				break;
			else
				System.out.println("Wrong choice");
		}

	}

}
