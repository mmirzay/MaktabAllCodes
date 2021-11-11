package com.project.my.classcodes.day0820.somelambdas;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
	public static void main(String[] args) {

		IntParserInterface intParser = Integer::parseInt;
		int num = intParser.parseInt("1");

		System.out.println("num: " + num);

		Predicate<Person> checkAge = s -> s.getAge() >= 30;
		Predicate<Person> checkName = s -> s.getName().toLowerCase().startsWith("a");

		Person person1 = new Person("Mohsen", 29);
		Person person2 = new Person("Ali", 30);

		System.out.println(checkAge.and(checkName).test(person1));
		System.out.println(checkAge.and(checkName).test(person2));

		BiFunction<String, Integer, Person> student = Student::new;
		Function<Person, Boolean> checkPersonName = p -> p.getName().toLowerCase().startsWith("a");
		Function<Person, Boolean> checkPersonAge = p -> p.getAge() > 30;

		System.out.println(student.andThen(checkPersonName).apply("Ali", 20));
		System.out.println(student.andThen(checkPersonAge).apply("Mohsen", 30));

		Supplier<Student> studentTest = () -> new Student("Ali", 20);
		Consumer<Student> namePrinter = s -> System.out.println(s.getName());
		Consumer<Student> agePrinter = s -> System.out.println(s.getAge());
		namePrinter.andThen(agePrinter).accept(studentTest.get());

	}
}
