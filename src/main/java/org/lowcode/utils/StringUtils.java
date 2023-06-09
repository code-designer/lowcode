package org.lowcode.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This provides a set of simple and useful functions for string
 * @author bigoh
 *
 */
public class StringUtils {
	
	/**
	 * Check whether a string is null or empty
	 * @param str
	 * @return boolean, true if it's valid
	 */
	public static boolean isValide(String str) {
		if (str == null)
			return false;
		return !str.trim().isEmpty();
	}
	
	/**
	 * check whether a string is digit 
	 * @param str is a string
	 * @return boolean, true if it's a digit
	 */
	public static boolean isDigit(String str) {
		if (!isValide(str))
			return false;
		return str.matches("^[0-9]+((\\.)[0-9]+)?$");
	}
	
	/**
	 * Check whether a string is an email
	 * @param str is a string
	 * @return boolean, true if it's an email
	 */
	public static boolean isEmail(String str) {
		if( !isValide(str))
			return false;
		return str.matches("^[a-z]{2,}+([-._]?[a-z0-9]+)*@[a-z0-9]+(\\.[a-z]{2,5})+$");
	}
	
	/**
	 * Capitalize the first printable letter without accent
	 * @param str is a string
	 * @return String that the first letter is capitalized
	 * @throws NullPointerException if the given string is not valid
	 */
	public static String capitalize (String str) throws NullPointerException {
		if(!isValide(str))
			throw new NullPointerException("Enter a valid string");
		
		return str.trim().substring(0,1).toUpperCase() + str.trim().substring(1);
	}
	
	/**
	 * Another way to capitalize the first printable letter without accent
	 * @param str is a string
	 * @return String that the first letter is capitalized
	 * @throws NullPointerException if the given string is not valid
	 */
	public static String toCapitalize(String str) throws NullPointerException {
		if(!isValide(str))
			throw new NullPointerException("Enter a valid string");
		
		char[] letters = str.toCharArray();
		int count = letters.length, i = 0;
		
		while (letters[i] == 32) {
			i++;
		}
		
		if (i < count && letters[i] > 96 && letters[i] < 123)
			letters[i] = (char) (letters[i] - 32);
		
		return new String(letters);
	}
	
	/**
	 * Capitalizing each word's first letter of a string
	 * @param str is a string
	 * @return String capitalized
	 * @throws NullPointerException if the given string is not valid
	 */
	public static String capitalizeAll (String str) throws NullPointerException {
		if(!isValide(str))
			throw new NullPointerException("Enter a valid string");
		
		String[] words = str.split(" ");
		
		StringBuilder sb = new StringBuilder();
		
		for (String word : words) {
			if (isValide(word))
				sb.append(capitalize(word)).append(" ");
		}
		return sb.toString().trim();
		
	}
	
	/**
	 * Capitalizing each word's first letter of a string
	 * @param str is a string
	 * @return String capitalized
	 * @throws NullPointerException if the given string is not valid
	 */
	public static String toCapitalizeAll (String str) throws NullPointerException {
		if(!isValide(str))
			throw new NullPointerException("Enter a valid string");
		
		char[] letters = str.toCharArray();
		int count = letters.length;
		boolean capitalized = false;
		
		for (int i = 0; i < count; i++) {
			if (letters[i] == 32) {
				capitalized = false;
				continue;
			}
			
			if(!capitalized) {
				if (letters[i] > 96 && letters[i] < 123)
					letters[i] = (char) (letters[i] - 32);
				capitalized = true;
			}
		}
		
		return new String(letters);
	}
	
	/**
	 * Shuffling characters of a string
	 * @param str
	 * @return string, shuffled string
	 * @throws NullPointerException, if the string is not valid
	 */
	public static String shuffle (String str) throws NullPointerException {
		if(!isValide(str))
			throw new NullPointerException("Enter a valid string");
		
		char[] letters = str.toCharArray();
		int count = letters.length;
		
		for (int i = 0; i < count; i++) {
			int rand = (int) (Math.random() * count);
			while (rand == i) {
				rand = (int) (Math.random() * count);
			}
			char temp = letters[i];
			letters[i] = letters[rand];
			letters[rand] = temp;
		}
		return new String(letters);
	}
	
	public static void main(String[] args) {
		System.out.println("Entrez un text");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		try {
			line = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Is valide : " + StringUtils.isValide(line));
		System.out.println("Is Digit : " + StringUtils.isDigit(line));
		System.out.println("Is Email : " + StringUtils.isEmail(line));
		System.out.println("capitalize :" + StringUtils.capitalize(line));
		System.out.println("capitalizeAll : " + StringUtils.capitalizeAll(line));
		System.out.println("shuffle : " + StringUtils.shuffle(line));
	}
}