package com.project.my.homeworks.hw15.q1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class IntStringConvertorTest {
	@Test
	public void convert_non_parsable_string_test() {
		String invalidTest1 = "58 9";
		assertThrows("It is invalid value with spaces, how could you convert it?!", IllegalArgumentException.class,
				() -> IntStringConvertor.convert(invalidTest1));

		String invalidTest2 = "S58";
		assertThrows("It is invalid value with some characters, how could you convert it?!",
				IllegalArgumentException.class, () -> IntStringConvertor.convert(invalidTest2));

	}

	@Test
	public void convert_invalid_range_string_test() {
		String invalidTest1 = "32768";
		assertThrows("It is invalid value with range greater than 32767, how could you convert it?!",
				IllegalArgumentException.class, () -> IntStringConvertor.convert(invalidTest1));

		String invalidTest2 = "-332768";
		assertThrows("It is invalid value with range less than -32767, how could you convert it?!",
				IllegalArgumentException.class, () -> IntStringConvertor.convert(invalidTest2));
	}

	@Test
	public void convert_valid_string_test() {
		int validTest1 = 32767;
		assertEquals("they must be same!!", validTest1, IntStringConvertor.convert(String.valueOf(validTest1)));

		int validTest2 = -12;
		assertEquals("they must be same!!", validTest2, IntStringConvertor.convert(String.valueOf(validTest2)));
	}
}
