package org.lowcode.utils;

public class StringUtils {
	
	public static boolean isValide(String str) {
		if (str == null)
			return false;
		return str.trim().isEmpty() ? false : true;
	}
	
//	public static void main (String[] args) {
//		
//	}
}
