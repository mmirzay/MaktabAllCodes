package com.project.my.classcodes.day0626.ir.javacup.salary;

public class Main {
	public static void main(String[] args) {
		System.out.println("Example 1: ");
		HrmSalaryListCreator creator = new HrmSalaryListCreator(new Encoder());
		Employee[] employees = new Employee[2];
		employees[0] = new Employee("71235", 1_500_000);
		employees[1] = new Employee("03451", 3_200_000);
		System.out.println(creator.doCreate(employees));

		System.out.println("Example 2: ");
		FmSalaryListCreator creator2 = new FmSalaryListCreator(new Encoder());
		Employee[] employees2 = new Employee[2];
		employees2[0] = new Employee("31235", 2_000_000);
		employees2[1] = new Employee("00531", 1_200_000);
		System.out.println(creator2.doCreate(employees2));;
	}
}
