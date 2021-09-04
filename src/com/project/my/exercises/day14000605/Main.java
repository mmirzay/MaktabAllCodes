package com.project.my.exercises.day14000605;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Student[] students = null;
		int index = 0;
		int studentCounter = 0;
		while (true) {
			System.out.println("1 --> add student\n" + "2-->calculate avg\n" + "3--> check accept\n" + "4--> exit");
			int number = scan.nextInt();
			switch (number) {
			case 1:
				if (students == null) { // new student[10];
					System.out.println("Enter number of Students: ");
					int studentNumber = scan.nextInt(); // 10
					students = new Student[studentNumber];// new Student[10];
				}

				if (index < students.length) {
					System.out.println("Enter id: ");
					int id = scan.nextInt();
					System.out.println("Enter first name: ");
					String firstName = scan.next();
					System.out.println("Enter last name: ");
					String lastName = scan.next();
					Student newStudent = new Student(id, firstName, lastName);
					System.out.println("Eneter grades, seperated by comma: ");
					scan.nextLine();
					String strGrades = scan.nextLine();// 12,15,13,10,20
					String[] array = strGrades.split(",");// {"12","15","13","10","20"};
					double[] grades = new double[array.length];
					for (int i = 0; i < grades.length; i++)
						grades[i] = Double.parseDouble(array[i]);
					newStudent.setGrades(grades);
					students[index] = newStudent;
					index++;
					studentCounter++;
					System.out.println("New student added successfully");
				} else
					System.out.println("Capacity is full. can not add new student.");
				break;
			case 2:
				System.out.println("Enter id:");
				int id = scan.nextInt();
				Student searched = null;
				for (Student student : students) // {mohsen, null,null,null,null,..}
					if (student != null && student.getId() == id) {
						searched = student;
						break;
					}
				if (searched == null)
					System.out.println("No such id");
				if (searched != null) {
					double avg = calculateAvg(searched);
					System.out.println("Average is " + avg);
				}

				break;
			case 3:
				System.out.println("Enter id:");
				int idp = scan.nextInt();
				Student searchedp = null;
				for (Student student : students) // {mohsen, null,null,null,null,..}
					if (student != null && student.getId() == idp) {
						searchedp = student;
						break;
					}
				if (searchedp == null)
					System.out.println("No such id");
				if (searchedp != null) {
					double avg = calculateAvg(searchedp);
					if (avg >= 10)
						System.out.println("Student is passed");
					else
						System.out.println("Student is not passed");
				}
				break;
			case 4:
				System.out.println("bye");
				return;

			}
		} // while true

	}// main

	public static double calculateAvg(Student student) {
		double sum = 0;
		for (double grade : student.getGrades())
			sum += grade;
		int numberOfGrades = student.getGrades().length;
		double avg = sum / numberOfGrades;
		return avg;
	}
}
