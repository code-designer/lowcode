package org.lowcode.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringUtilsTest {

	@Test
	public void testIsValid() {
		String str = "a common string";
		assertTrue(StringUtils.isValid(str), "la chaine passee est bien valide");
		
		str = "   ";
		assertFalse(StringUtils.isValid(str), "la chaine passe est invalide");
				
		str = "12";
		assertTrue(StringUtils.isValid(str), "la chaine passee est bien valide");
		
		String str1 = null;
		assertFalse(StringUtils.isValid(str1), "La chaine passee est invalide");
	}
	
	@Test
	void testIsDigit() {
		String str = "12";
		assertTrue(StringUtils.isDigit(str), "12 est un nombre");
		
		str = "23a";
		assertFalse(StringUtils.isDigit(str), "23a n'est pas un nombre");
		
		str = "23 4";
		assertFalse(StringUtils.isDigit(str), "23 4 n'est pas un nombre");
		
		str = "56.31";
		assertTrue(StringUtils.isDigit(str), "56.31 est un nombre");
		
		str = ".890";
		assertFalse(StringUtils.isDigit(str), ".890 n'est pas un nombre");
		
		str = "81.2.34";
		assertFalse(StringUtils.isDigit(str), "81.2.34 n'est pas un nombre");
	}
	
	@Test
	void testIsDigit2() {
		String str = "12";
		assertTrue(StringUtils.isDigit2(str), "12 est un nombre");
		
		str = "23a";
		assertFalse(StringUtils.isDigit2(str), "23a n'est pas un nombre");
		
		str = "23 4";
		assertFalse(StringUtils.isDigit2(str), "23 4 n'est pas un nombre");
		
		str = "56.31";
		assertTrue(StringUtils.isDigit2(str), "56.31 est un nombre");
		
		str = ".890";
		assertFalse(StringUtils.isDigit2(str), ".890 n'est pas un nombre");
		
		str = "81.2.34";
		assertFalse(StringUtils.isDigit2(str), "81.2.34 n'est pas un nombre");
	}
	
	@Test
	void testIsEmail() {
		String str = "code@java.net";
		assertTrue(StringUtils.isEmail(str), "code@java.net est un mail valide");
		
		str = "my.code@java.edu.net";
		assertTrue(StringUtils.isEmail(str), "my.code@java.edu.net est un mail valide");
		
		str = "java-script@web.org";
		assertTrue(StringUtils.isEmail(str), "java-script@web.org est un mail valide");
		
		str = "code2@java.net";
		assertTrue(StringUtils.isEmail(str), "code2@java.net est un mail valide");
		
		str = "my.java-script@web.net";
		assertTrue(StringUtils.isEmail(str), "my.java-script@web.net est un mail valide");
		
		str = "my.java-script@3hyper-web.js.net";
		assertTrue(StringUtils.isEmail(str), "my.java-script@3hyper-web.js.net est un mail valide");
		
		str = ".code@java.net";
		assertFalse(StringUtils.isEmail(str), ".code@java.net n'est pas valide");
		
		str = "2code@java.net";
		assertFalse(StringUtils.isEmail(str), "2code@java.net n'est pas valide");
		
		str = "mymail.courrier.net";
		assertFalse(StringUtils.isEmail(str), "mymail.courrier.net n'est pas valide");
		
		str = "my..code@java.net";
		assertFalse(StringUtils.isEmail(str), "my..code@java.net n'est pas valide");
		
		str = "code@java..net";
		assertFalse(StringUtils.isEmail(str), "code@java..net n'est pas valide");
		
		str = "mymail@courrier@group.net";
		assertFalse(StringUtils.isEmail(str), "mymail@courrier@group.net n'est pas valide");
	}
	
	@Test
	void testCapitalize() {
		String str = "hello1";
		assertEquals("Hello1", StringUtils.capitalize(str), "hello1 non capitalisé");
		str = " hello2";
		assertEquals("Hello2", StringUtils.capitalize(str), "hello2 non capitalisé");
		str = "hello amigo";
		assertEquals("Hello amigo", StringUtils.capitalize(str), "hello amigo non capitalisé");
		str = "Hello3";
		assertEquals("Hello3", StringUtils.capitalize(str), "Hello3 non capitalisé");
		
		assertThrows(NullPointerException.class, ()->{
			StringUtils.capitalize(null);
			});
	}
	
	@Test
	void testToCapitalize() {
		String str = "hello1";
		assertEquals("Hello1", StringUtils.toCapitalize(str), "hello1 non capitalisé");
		str = " hello2";
		assertEquals(" Hello2", StringUtils.toCapitalize(str), "hello2 non capitalisé");
		str = "hello amigo";
		assertEquals("Hello amigo", StringUtils.toCapitalize(str), "hello amigo non capitalisé");
		str = "Hello3";
		assertEquals("Hello3", StringUtils.toCapitalize(str), "Hello3 non capitalisé");
		
		assertThrows(NullPointerException.class, ()->{
			StringUtils.toCapitalize(null);
			});
	}
	
	@Test 
	void testCapitalizeAll() {
		String str = "happy birthday";
		assertEquals("Happy Birthday", StringUtils.capitalizeAll(str), "happy birthday non capitalisé");
		
		str = "hello amigo";
		assertEquals("Hello Amigo", StringUtils.capitalizeAll(str), "hello amigo non capitalisé");
		
		str = "that is a good day";
		assertEquals("That Is A Good Day", StringUtils.capitalizeAll(str), "that is a good day non capitalisé");
		
		str = "That Is a good day";
		assertEquals("That Is A Good Day", StringUtils.capitalizeAll(str), "That Is a good day non capitalisé");
		
		assertThrows(NullPointerException.class, ()->{
			StringUtils.capitalizeAll(null);
			});
	}
	
	@Test 
	void testToCapitalizeAll() {
		String str = "happy birthday ";
		assertEquals("Happy Birthday ", StringUtils.toCapitalizeAll(str), "happy birthday non capitalisé");
		
		str = " hello  amigo";
		assertEquals(" Hello  Amigo", StringUtils.toCapitalizeAll(str), "hello amigo non capitalisé");
		
		str = "that is  a good day";
		assertEquals("That Is  A Good Day", StringUtils.toCapitalizeAll(str), "that is a good day non capitalisé");
		
		str = "That Is  a good day";
		assertEquals("That Is  A Good Day", StringUtils.toCapitalizeAll(str), "That Is a good day non capitalisé");
		
		assertThrows(NullPointerException.class, ()->{
			StringUtils.toCapitalizeAll(null);
			});
	}
	
	@Test
	void testShuffle() {
		String str = "happiness";
		assertNotEquals("happiness", StringUtils.shuffle(str), "non capitalisé");
		
		str = "awesome";
		assertNotEquals("awesome", StringUtils.shuffle(str), "non capitalisé");
		
		str = "greatness";
		assertNotEquals("greatness", StringUtils.shuffle(str), "non capitalisé");
	}
	
	@Test
	void testReverse() {
		String str = "abcdefghij";
		assertEquals("jihgfedcba", StringUtils.reverse(str), "bad reverse");
		
		str = "ressasser";
		assertEquals(str, StringUtils.reverse(str), "bad reverse");
		
	}

}
