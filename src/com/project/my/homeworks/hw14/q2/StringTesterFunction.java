package com.project.my.homeworks.hw14.q2;

import java.util.function.Predicate;

//Write a lambda expression that tests whether a word starts and ends with the same letter.
public class StringTesterFunction {
	public static void main(String[] args) {
		String word1 = "Java";
		String word2 = "PHP";

		Predicate<String> stringTester = s -> s.endsWith(String.valueOf(s.charAt(0)));
		System.out.printf("%s is %s%n", word1, stringTester.test(word1));
		System.out.printf("%s is %s%n", word2, stringTester.test(word2));
	}
}
