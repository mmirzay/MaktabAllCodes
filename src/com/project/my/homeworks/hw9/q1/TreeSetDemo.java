package com.project.my.homeworks.hw9.q1;

import java.util.Random;
import java.util.TreeSet;

public class TreeSetDemo {
	public static void main(String[] args) {
		TreeSet<Character> treeSet1 = new TreeSet<>();
		TreeSet<Character> treeSet2 = new TreeSet<>();
		for (int i = 0; i < 10; i++) {
			char randomChar1 = (char) ('a' + new Random().nextInt('z' - 'a' + 1));
			char randomChar2 = (char) ('a' + new Random().nextInt('z' - 'a' + 1));
			treeSet1.add(randomChar1);
			treeSet2.add(randomChar2);
		}

		printTreeSet(treeSet1, "TreeSet#1");
		printTreeSet(treeSet2, "TreeSet#2");
		printTreeSet(union(treeSet1, treeSet2), "UNION");
		printTreeSet(intersect(treeSet1, treeSet2), "INTERECT");
	}

	private static void printTreeSet(TreeSet<?> treeSet, String title) {
		System.out.println(String.format("%-12s", title+":") + treeSet);
	}

	private static TreeSet<Character> union(TreeSet<Character> treeSet1, TreeSet<Character> treeSet2) {
		TreeSet<Character> result = new TreeSet<>();
		result.addAll(treeSet1);
		result.addAll(treeSet2);
		return result;
	}

	private static TreeSet<Character> intersect(TreeSet<Character> treeSet1, TreeSet<Character> treeSet2) {
		TreeSet<Character> result = new TreeSet<>();
		result.addAll(treeSet1);
		result.retainAll(treeSet2);
		return result;
	}
}
