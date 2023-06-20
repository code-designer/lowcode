package org.lowcode.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FileUtilsTest {

	@Test
	void testGetExtention() {
		String path = "C:\\Users\\bigoh\\Documents\\p022_names.txt";
		assertEquals("txt", FileUtils.getExtension(path), "something wrong");
		
		path = "C:\\Users\\bigoh\\Documents\\p022_name";
		assertEquals(null, FileUtils.getExtension(path), "something wrong");
	}
	
	

}
