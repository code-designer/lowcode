package org.lowcode.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringUtilsTest {

	@Test
	void testIsValide() {
		String str = "a common string";
		assertTrue(StringUtils.isValide(str), "la chaine passee est bien valide");
		
		str = "   ";
		assertFalse(StringUtils.isValide(str), "la chaine passe est invalide");
		
		str = null;
		assertFalse(StringUtils.isValide(str), "la chaine passe est invalide");
		
		str = "12";
		assertTrue(StringUtils.isValide(str), "la chaine passee est bien valide");
	}

}
