package com.project.my.classcodes.day0626.ir.javacup.salary;

public class Encoder {

	protected int maxLength;

	public String encode(String str) {
		if (str.length() < maxLength)
			return addZeroPrefix(str, maxLength - str.length());
		return str;
	}

	protected static String addZeroPrefix(String str, int length) {
		return "0".repeat(length).concat(str);
	}

	public Encoder setMaxLength(int maxLength) {
		this.maxLength = maxLength;
		return this;
	}

}
