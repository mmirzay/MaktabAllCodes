package com.project.my.homeworks.hw14.q4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StringGroupingBy {
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("Amir", "Hatef", "Mehran", "Mojtaba", "Mohammad", "Ali", "Davood", "Reza",
				"Mohsen");
		Long numberOfNames = strings.stream().collect(Collectors.counting());
		System.out.println("Number of Names: " + numberOfNames);
		Optional<String> longestName = strings.stream()
				.collect(Collectors.maxBy((o1, o2) -> o1.toString().length() - o2.toString().length()));
		System.out.println("Longest Name: " + longestName.get());
		Optional<String> shortestName = strings.stream()
				.collect(Collectors.minBy((o1, o2) -> o1.toString().length() - o2.toString().length()));
		System.out.println("Shortest Name: " + shortestName.get());

		System.out.println("Grouping Names: ");
		strings.stream().collect(Collectors.groupingBy(t -> t.toString().length()))
				.forEach((k, v) -> System.out.print(v));
		System.out.println();
		System.out.println("Grouping Names and Length: ");
		Map<Integer, List<String>> groupingByLength = strings.stream()
				.collect(Collectors.groupingBy(t -> t.toString().length()));
		System.out.println(groupingByLength);

	}
}
