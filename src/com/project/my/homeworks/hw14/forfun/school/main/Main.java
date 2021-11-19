package com.project.my.homeworks.hw14.forfun.school.main;

import com.project.my.homeworks.hw14.forfun.school.Course;
import com.project.my.homeworks.hw14.forfun.school.FullTimeTeacher;
import com.project.my.homeworks.hw14.forfun.school.PartTimeTeacher;
import com.project.my.homeworks.hw14.forfun.school.School;
import com.project.my.homeworks.hw14.forfun.school.Teacher;
import com.project.my.homeworks.hw14.forfun.school.TeachersController;
import com.project.my.homeworks.hw14.forfun.school.enums.Degree;

public class Main {

	public static void main(String[] args) {

		Course course1 = new Course("math", 1);
		Course course2 = new Course("computer", 2);
		Course course3 = new Course("physic", 3);
		Course course4 = new Course("history", 4);
		Course course5 = new Course("art", 5);

		School school1 = new School("maktab", 1);
		School school2 = new School("madani", 2);
		School school3 = new School("alavi", 3);
		School school4 = new School("razavi", 3);
		School school5 = new School("jalal", 1);
		School school6 = new School("diba", 1);

		Teacher teacher1 = new FullTimeTeacher("Mohsen", "Mohseni", "1", 1_000_000);
		teacher1.setExperienceYear(10);
		Teacher teacher2 = new FullTimeTeacher("Ali", "Aliei", "2", 2_000_000);
		teacher2.setExperienceYear(11);
		Teacher teacher3 = new FullTimeTeacher("Javad", "Javadi", "3", 3_000_000);
		teacher3.setExperienceYear(11);
		Teacher teacher4 = new FullTimeTeacher("ahmad", "ahmadi", "4", 2_000_000);
		teacher4.setExperienceYear(10);
		
		Teacher teacher5 = new PartTimeTeacher("ramin", "ramini", "5", 120, 10_000);
		teacher5.setExperienceYear(10);
		teacher5.setDegree(Degree.BS);
		Teacher teacher6 = new PartTimeTeacher("fardin", "fardini", "6", 120, 11_000);
		teacher6.setExperienceYear(12);
		teacher6.setDegree(Degree.BS);
		Teacher teacher7 = new PartTimeTeacher("milad", "miladi", "7", 140, 50_000);
		teacher7.setExperienceYear(20);
		teacher7.setDegree(Degree.BS);

		TeachersController controller = new TeachersController();
		controller.addSchoolForTeacher(school1, teacher1);
		controller.addSchoolForTeacher(school1, teacher2);
		controller.addSchoolForTeacher(school1, teacher3);

		controller.addSchoolForTeacher(school2, teacher3);

		controller.addSchoolForTeacher(school3, teacher7);
		controller.addSchoolForTeacher(school3, teacher6);
		controller.addSchoolForTeacher(school3, teacher5);

		controller.addSchoolForTeacher(school4, teacher5);
		controller.addSchoolForTeacher(school4, teacher6);

		controller.addSchoolForTeacher(school5, teacher5);
		controller.addSchoolForTeacher(school5, teacher4);

		controller.addSchoolForTeacher(school6, teacher4);
		controller.addSchoolForTeacher(school6, teacher5);

		controller.addCourceForTeacher(course1, teacher7);
		controller.addCourceForTeacher(course1, teacher5);

		controller.addCourceForTeacher(course2, teacher5);
		controller.addCourceForTeacher(course2, teacher4);
		controller.addCourceForTeacher(course2, teacher3);

		controller.addCourceForTeacher(course3, teacher1);
		controller.addCourceForTeacher(course3, teacher2);

		controller.addCourceForTeacher(course4, teacher2);
		controller.addCourceForTeacher(course4, teacher1);

		controller.addCourceForTeacher(course5, teacher6);

		System.out.println(teacher1+" Schools: " + teacher1.getSchool());
		System.out.println(teacher2+" Schools: " + teacher2.getSchool());
		System.out.println(teacher3+" Schools: " + teacher3.getSchool());
		System.out.println(teacher4+" Schools: " + teacher4.getSchool());
		System.out.println(teacher5+" Schools: " + teacher5.getSchool());
		System.out.println(teacher6+" Schools: " + teacher6.getSchool());
		System.out.println("-".repeat(50));
		System.out.println(teacher1+" Courses: " + teacher1.getCourse());
		System.out.println(teacher2+" Courses: " + teacher2.getCourse());
		System.out.println(teacher3+" Courses: " + teacher3.getCourse());
		System.out.println(teacher4+" Courses: " + teacher4.getCourse());
		System.out.println(teacher5+" Courses: " + teacher5.getCourse());
		System.out.println(teacher6+" Courses: " + teacher6.getCourse());
		System.out.println("-".repeat(50));
		System.out.println("controller.listOfTeachersWithHigherSalaryThanFullTimeTeachers(): ");
		controller.listOfTeachersWithHigherSalaryThanFullTimeTeachers().forEach(System.out::println);
		System.out.println("-".repeat(50));
		System.out.println("controller.listOf10YearsExperiencedTeachers()");
		System.out.println(controller.listOf10YearsExperiencedTeachers());
		System.out.println("-".repeat(50));
		System.out.println("controller.listOfBachelorPartTimeTeachersInTwoDegreeSchoolAndMoreThanTwoCourses(): ");
		System.out.println(controller.listOfBachelorPartTimeTeachersInTwoDegreeSchoolAndMoreThanTwoCourses());
		System.out.println("-".repeat(50));
		System.out.println("controller.getAllSchoolsName():");
		System.out.println(controller.getAllSchoolsName());
		System.out.println("-".repeat(50));
		System.out.println("controller.getAllSchoolsTeachersList(): ");
		System.out.println(controller.getAllSchoolsTeachersList());
	}

}
