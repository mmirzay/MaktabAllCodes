package com.project.my.homeworks.hw15.q1;

public class IntStringConvertor {
	public static int convert(String s) {
		try {
			Integer result = Integer.parseInt(s);
			if (result < -32_767 || result > 32_767)
				throw new IllegalArgumentException("Invalid range to convert.");
			return result;
		} catch (NullPointerException | NumberFormatException e) {
			throw new IllegalArgumentException("Invalid string to convert");
		}
	}
}
