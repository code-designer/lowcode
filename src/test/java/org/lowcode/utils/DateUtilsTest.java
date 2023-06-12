package org.lowcode.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import org.junit.jupiter.api.Test;

class DateUtilsTest {

	@Test
	void testToLocalDate() {
		String date = "12-05-2021", pattern = "dd-MM-yyyy";
		LocalDate lc = LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
		assertEquals(lc, DateUtils.toLocalDate(date, pattern));
		
		String d = null, p = "dd-MM-yyyy";
		assertThrows(NullPointerException.class, ()->{
			DateUtils.toLocalDate(d, p);
		});
		
		String date1 = "12/05/2021";
		String pattern1 = "dd-MMM-yyyy";
		assertThrows(DateTimeParseException.class, ()->{
			DateUtils.toLocalDate(date1, pattern1);
		});
	}
	
	@Test
	void testToLocalDate2() {
		String date = "12/05/2021", pattern = "dd/MM/yyyy";
		LocalDate lc = LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern, Locale.FRANCE));
		assertEquals(lc, DateUtils.toLocalDate(date, pattern));
				
		String d = null, p = "dd-MM-yyyy";
		assertThrows(NullPointerException.class, ()->{
			DateUtils.toLocalDate(d, p, Locale.FRANCE);
		});
		
		String date1 = "12/05/2021";
		String pattern1 = "dd-MMM-yyyy";
		assertThrows(DateTimeParseException.class, ()->{
			DateUtils.toLocalDate(date1, pattern1, Locale.FRANCE);
		});
	}
	
	@Test
	void testDaysLeft() {
		String date = "12-05-2021", pattern = "dd-MM-yyyy";
		LocalDate lc = LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern, Locale.FRANCE));
		
		String date2 = "12-06-2021";
		LocalDate lc2 = LocalDate.parse(date2, DateTimeFormatter.ofPattern(pattern, Locale.FRANCE));
		
		assertEquals("P1M", DateUtils.daysLeft(lc, lc2).toString());
	}
	
	

}
