package com.project.my.classcodes.day0820.somestreams;

import java.util.ArrayList;
import java.util.List;

class Main {

	public static void main(String[] args) {
		List<Car> cars = new ArrayList<>();

		cars.add(new Car("Benz", 18000));
		cars.add(new Car("Toyota", 9000));
		cars.add(new Car("BMW", 20000));
		cars.add(new Car("Peykan", 1000));

		cars.stream()
		.filter(c -> c.getPrice() > 10000)
		.sorted((o1,o2) -> o2.getPrice() - o1.getPrice())
		.forEach(System.out::println);
	}
}
