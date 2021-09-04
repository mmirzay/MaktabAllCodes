package com.project.my.classcodes.uniparty;

public class University {
	private Employee[] employees;
	private int addedEmployees;

	public University(int numberOfEmployees) {
		this.employees = new Employee[numberOfEmployees];
	}

	public void addEmployee(Employee employee) {
		if (addedEmployees >= employees.length) {
			System.out.println("All employees are added.");
			return;
		}
		employees[addedEmployees++] = employee;
		System.out.println(employee + " added.");
	}

	public void addSpouseById(int id, Name spouseName) {
		for (Employee employee : employees)
			if (employee != null && employee.getId() == id) {
				employee.setSpouseName(spouseName);
				System.out.println(spouseName + "added as spouse of " + employee.getName());
				return;
			}
		System.out.println("No such Id exists.");
	}

	public void showMarriageStatusById(int id) {
		for (Employee employee : employees)
			if (employee != null && employee.getId() == id) {
				System.out.println("This employee is " + employee.getMarriageStatus());
				return;
			}
		System.out.println("No such Id exists.");
	}

	public void showInvitationStatusById(int id) {
		for (Employee employee : employees)
			if (employee != null && employee.getId() == id) {
				System.out.printf("This employee is %s to the party.",
						Party.isInvited(employee) ? "invited" : "NOT invited");
				return;
			}
		System.out.println("No such Id exists.");
	}
}
