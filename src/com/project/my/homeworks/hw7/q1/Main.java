package com.project.my.homeworks.hw7.q1;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	static Scanner input;

	public static void main(String[] args) {
		Main ui = new Main();
		System.out.println("Connecting to database maktab_schema...");
		SimpleDbManager db = new SimpleDbManager();
		input = new Scanner(System.in);
		try {
			long start = System.currentTimeMillis();
			db.initialeDatabase();
			long end = System.currentTimeMillis();
			System.out.println("Database is conneted in " + (end - start) / 1000 + " seconds.");
		} catch (SQLException e) {
			ui.printErrorMessage("Error while creating database: " + e.getMessage());
		}

		while (true) {
			ui.printMenu();
			switch (ui.getIntInputValue(" >>")) {
			case 1: {
				int id = ui.getIntInputValue("Enter teacher id:");
				try {
					if (db.isDuplicateTeacherId(id)) {
						ui.printErrorMessage("Id is duplicate.");
						continue;
					}
				} catch (SQLException e) {
					ui.printErrorMessage("Error while checking duplicate teacher id: " + e.getMessage());
					continue;
				}

				String firstName = ui.getStringInputValue("Enter teacher first name:");
				String lastName = ui.getStringInputValue("Enter teacher last name:");
				Teacher teacher = new Teacher(id, firstName, lastName);
				try {
					db.addNewTeacher(teacher);
				} catch (SQLException e) {
					ui.printErrorMessage("Error while adding new teacher: " + e.getMessage());
					continue;
				}
				ui.printInfoMessage("New teacher is added.");
			}
				break;
			case 2: {
				int id = ui.getIntInputValue("Enter teacher id to edit:");
				try {
					if (db.isDuplicateTeacherId(id) == false) {
						ui.printErrorMessage("Id is not exist");
						continue;
					}
				} catch (SQLException e) {
					ui.printErrorMessage("Error while checking teacher id to edit: " + e.getMessage());
					continue;
				}

				String firstName = ui.getStringInputValue("Enter new first name:");
				String lastName = ui.getStringInputValue("Enter new last name:");
				Teacher teacher = new Teacher(id, firstName, lastName);
				try {
					db.updateTeacher(teacher);
				} catch (SQLException e) {
					ui.printErrorMessage("Error while updating teacher:" + e.getMessage());
					continue;
				}

				ui.printInfoMessage("Teacher updated.");
			}
				break;
			case 3: {
				int id = ui.getIntInputValue("Enter teacher id to remove:");
				try {
					if (db.isDuplicateTeacherId(id) == false) {
						ui.printErrorMessage("Id is not exist");
						continue;
					}
				} catch (SQLException e) {
					ui.printErrorMessage("Error while checking teacher id to remove: " + e.getMessage());
					continue;
				}

				try {
					db.removeTeacherById(id);
				} catch (SQLException e) {
					ui.printErrorMessage("Error while removing teacher:" + e.getMessage());
					continue;
				}

				ui.printInfoMessage("Teacher removed.");
			}
				break;
			case 4: {
				ui.printTitle("Teachers List:");
				try {
					System.out.println(db.fetchAllTeachers());
				} catch (SQLException e) {
					ui.printErrorMessage("Error while fetching all teachers:" + e.getMessage());
				}
			}
				break;
			case 5: {
				int id = ui.getIntInputValue("Enter student id:");
				try {
					if (db.isDuplicateStudentId(id)) {
						ui.printErrorMessage("Id is duplicate.");
						continue;
					}
				} catch (SQLException e) {
					ui.printErrorMessage("Error while checking duplicate student id: " + e.getMessage());
					continue;
				}

				String firstName = ui.getStringInputValue("Enter student first name:");
				String lastName = ui.getStringInputValue("Enter student last name:");
				Student student = new Student(id, firstName, lastName);
				try {
					db.addNewStudent(student);
				} catch (SQLException e) {
					ui.printErrorMessage("Error while adding new student: " + e.getMessage());
					continue;
				}
				ui.printInfoMessage("New student is added.");
			}
				break;
			case 6: {
				int id = ui.getIntInputValue("Enter student id to edit:");
				try {
					if (db.isDuplicateStudentId(id) == false) {
						ui.printErrorMessage("Id is not exist");
						continue;
					}
				} catch (SQLException e) {
					ui.printErrorMessage("Error while checking student id to edit: " + e.getMessage());
					continue;
				}

				String firstName = ui.getStringInputValue("Enter new first name:");
				String lastName = ui.getStringInputValue("Enter new last name:");
				Student student = new Student(id, firstName, lastName);
				try {
					db.updateStudent(student);
				} catch (SQLException e) {
					ui.printErrorMessage("Error while updating student:" + e.getMessage());
					continue;
				}

				ui.printInfoMessage("student updated.");
			}
				break;
			case 7: {
				int id = ui.getIntInputValue("Enter student id to remove:");
				try {
					if (db.isDuplicateStudentId(id) == false) {
						ui.printErrorMessage("Id is not exist");
						continue;
					}
				} catch (SQLException e) {
					ui.printErrorMessage("Error while checking student id to remove: " + e.getMessage());
					continue;
				}

				try {
					db.removeStudentById(id);
				} catch (SQLException e) {
					ui.printErrorMessage("Error while removing student:" + e.getMessage());
					continue;
				}

				ui.printInfoMessage("student removed.");
			}
				break;
			case 8: {
				ui.printTitle("Students List:");
				try {
					System.out.println(db.fetchAllStudents());
				} catch (SQLException e) {
					ui.printErrorMessage("Error while fetching all students:" + e.getMessage());
				}
			}
				break;
			case 9: {
				int teacherId = ui.getIntInputValue("Enter teacher id:");
				try {
					if (db.isDuplicateTeacherId(teacherId) == false) {
						ui.printErrorMessage("Teacher id is not exist.");
						continue;
					}
				} catch (SQLException e) {
					ui.printErrorMessage("Error while checking teacher id: " + e.getMessage());
					continue;
				}

				int studentId = ui.getIntInputValue("Enter student id:");
				try {
					if (db.isDuplicateStudentId(studentId) == false) {
						ui.printErrorMessage("Student id is not exist.");
						continue;
					}
				} catch (SQLException e) {
					ui.printErrorMessage("Error while checking student id: " + e.getMessage());
					continue;
				}

				try {
					if (db.isStudentAssignedForTeacher(teacherId, studentId)) {
						ui.printErrorMessage("Student is assigned to teacher already.");
						continue;
					}
				} catch (SQLException e) {
					ui.printErrorMessage("Error while checking assigning student to teacher: " + e.getMessage());
					continue;
				}

				try {
					db.assignStudentForTeacher(teacherId, studentId);
				} catch (SQLException e) {
					ui.printErrorMessage("Error while assigning student to teacher: " + e.getMessage());
					continue;
				}

				ui.printInfoMessage("Student is assigned to teacher.");
			}
				break;

			case 10: {
				int teacherId = ui.getIntInputValue("Enter teacher id:");
				try {
					if (db.isDuplicateTeacherId(teacherId) == false) {
						ui.printErrorMessage("Teacher id is not exist.");
						continue;
					}
				} catch (SQLException e) {
					ui.printErrorMessage("Error while checking teacher id: " + e.getMessage());
					continue;
				}

				int studentId = ui.getIntInputValue("Enter student id:");
				try {
					if (db.isDuplicateStudentId(studentId) == false) {
						ui.printErrorMessage("Student id is not exist.");
						continue;
					}
				} catch (SQLException e) {
					ui.printErrorMessage("Error while checking student id: " + e.getMessage());
					continue;
				}

				try {
					if (db.isStudentAssignedForTeacher(teacherId, studentId) == false) {
						ui.printErrorMessage("Student is not assigned to teacher already.");
						continue;
					}
				} catch (SQLException e) {
					ui.printErrorMessage("Error while checking assigning student to teacher: " + e.getMessage());
					continue;
				}

				try {
					db.removeStudentOfTeacher(teacherId, studentId);
				} catch (SQLException e) {
					ui.printErrorMessage("Error while removing student of teacher: " + e.getMessage());
					continue;
				}

				ui.printInfoMessage("Student is removed of teacher.");
			}
				break;
			case 11: {
				int teacherId = ui.getIntInputValue("Enter teacher id:");
				try {
					if (db.isDuplicateTeacherId(teacherId) == false) {
						ui.printErrorMessage("Teacher id is not exist.");
						continue;
					}
				} catch (SQLException e) {
					ui.printErrorMessage("Error while checking teacher id: " + e.getMessage());
					continue;
				}
				ui.printTitle("Teacher's Students List:");
				try {
					System.out.println(db.fetchAllTeachersStudents(teacherId));
				} catch (SQLException e) {
					e.printStackTrace();
					ui.printErrorMessage("Error while fetching teacher's students:" + e.getMessage());
				}
			}
				break;
			case 12: {
				int studentId = ui.getIntInputValue("Enter student id:");
				try {
					if (db.isDuplicateStudentId(studentId) == false) {
						ui.printErrorMessage("Student id is not exist.");
						continue;
					}
				} catch (SQLException e) {
					ui.printErrorMessage("Error while checking student id: " + e.getMessage());
					continue;
				}
				ui.printTitle("Student's Teachers List:");
				try {
					System.out.println(db.fetchAllStudentsTeachers(studentId));
				} catch (SQLException e) {
					e.printStackTrace();
					ui.printErrorMessage("Error while fetching student's teachers:" + e.getMessage());
				}
			}
				break;
			case 13:
				return;
			default:
				ui.printErrorMessage("Invalid selection.");
			}// switch
		} // while
	}// main

	private void printMenu() {
		printTitle("Main Menu");
		System.out.println("Teachers: ");
		System.out.println("	1- add teacher");
		System.out.println("	2- edit teacher");
		System.out.println("	3- remove teacher");
		System.out.println("	4- show all teachers");
		System.out.println("Students: ");
		System.out.println("	5- add student");
		System.out.println("	6- edit student");
		System.out.println("	7- remove student");
		System.out.println("	8- show all students");
		System.out.println("Class:");
		System.out.println("	9-  assign teacher's student");
		System.out.println("	10- remove teacher's student");
		System.out.println("	11- show teacher's students");
		System.out.println("	12- show student's teachers");
		System.out.println("13- exit");
		System.out.println("-".repeat(50));
	}

	private String getOptionalStringInputValue(String msg) {
		System.out.print(msg + " ");
		return input.nextLine().trim();
	}

	private String getStringInputValue(String msg) {
		String result = null;
		while (true) {
			result = getOptionalStringInputValue(msg);
			if (result.isEmpty())
				printErrorMessage("Invalid input!");
			else
				return result;
		}
	}

	private int getIntInputValue(String msg) {
		while (true)
			try {
				return Integer.parseInt(getStringInputValue(msg));
			} catch (Exception e) {
				printErrorMessage("Invalid input!");
				if (msg.isEmpty())
					System.out.print(">> ");
			}
	}

	private void printErrorMessage(String msg) {
		System.out.println();
		System.out.println("| Error: " + msg + " |");
		printWaitingMessage();
	}

	private void printInfoMessage(String msg) {
		System.out.println();
		System.out.println(">>> " + msg + " <<<");
		printWaitingMessage();
	}

	private void printWaitingMessage() {
		System.out.println("_____________ press Enter to continue...");
		input.nextLine();
	}

	private void printTitle(String title) {
		System.out.println("-".repeat(50));
		for (int i = 0; i < 50 / 2 - title.length() / 2; i++)
			System.out.print(" ");
		System.out.println(title);
		System.out.println("-".repeat(50));
	}
}
