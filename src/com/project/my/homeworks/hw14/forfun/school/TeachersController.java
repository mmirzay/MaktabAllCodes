package com.project.my.homeworks.hw14.forfun.school;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.project.my.homeworks.hw14.forfun.school.enums.Degree;
import com.project.my.homeworks.hw14.forfun.school.enums.TeacherType;

public class TeachersController {
	private Set<Teacher> teachers = new LinkedHashSet<>();

	public void addTeacher(Teacher teacher) {
		teachers.remove(teacher);
		teachers.add(teacher);
	}

	public void addSchoolForTeacher(School school, Teacher teacher) {
		teacher.getSchool().add(school);
		addTeacher(teacher);
	}

	public void addCourceForTeacher(Course course, Teacher teacher) {
		teacher.getCourse().add(course);
		addTeacher(teacher);
	}

	public List<Teacher> listOfTeachersWithHigherSalaryThanFullTimeTeachers() {
		double avgFullTimeTeachersSalary = teachers.stream().filter(t -> t.getType() == TeacherType.FULL_TIME)
				.collect(Collectors.averagingDouble(Teacher::calculateSalary));
		return teachers.stream().filter(t -> t.calculateSalary() > avgFullTimeTeachersSalary)
				.collect(Collectors.toList());
	}

	public Map<TeacherType, List<Teacher>> listOf10YearsExperiencedTeachers() {
		return teachers.stream().filter(t -> t.getExperienceYear() == 10)
				.collect(Collectors.groupingBy(Teacher::getType));
	}

	public List<Teacher> listOfBachelorPartTimeTeachersInTwoDegreeSchoolAndMoreThanTwoCourses() {
		Predicate<Teacher> partTime = t -> t.getType() == TeacherType.PART_TIME;
		Predicate<Teacher> bachelorDegree = t -> t.getDegree() == Degree.BS;
		Predicate<Teacher> twoDegreeSchool = t -> t.getSchool().stream().anyMatch(s -> s.getDegree() == 3);
		Predicate<Teacher> twoCourses = t -> t.getCourse().size() >= 2;
		return teachers.stream().filter(partTime.and(bachelorDegree).and(twoDegreeSchool).and(twoCourses))
				.collect(Collectors.toList());
	}

	public Set<String> getAllSchoolsName() {
		Set<String> result = new HashSet<>();
		teachers.stream()
				.forEach(t -> result.addAll(t.getSchool().stream().map(s -> s.getName()).collect(Collectors.toSet())));
		return result;
	}

	public Map<String, Set<Teacher>> getAllSchoolsTeachersList() {
		Map<String, Set<Teacher>> result = new HashMap<>();
		for (Teacher t : teachers)
			for (School s : t.getSchool())
				if (result.containsKey(s.getName()))
					result.get(s.getName()).add(t);
				else
					result.put(s.getName(), new HashSet<>(List.of(t)));
		return result;
	}
}
