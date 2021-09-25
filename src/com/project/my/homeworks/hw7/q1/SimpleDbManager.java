package com.project.my.homeworks.hw7.q1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleDbManager {

	void initialeDatabase() throws SQLException {
		String createSchema = "CREATE DATABASE IF NOT EXISTS maktab_schema";
		String createStudenTable = "CREATE TABLE IF NOT EXISTS maktab_schema.student (\n" + "id INT NOT NULL,\n"
				+ "	first_name varchar(100) NOT NULL,\n" + "	last_name varchar(100) NOT NULL,\n"
				+ "	CONSTRAINT Student_pk PRIMARY KEY (id)\n" + ")\n" + "ENGINE=InnoDB\n;";
		String createTeacherTable = "CREATE TABLE IF NOT EXISTS maktab_schema.teacher (\n" + "id INT NOT NULL,\n"
				+ "	first_name varchar(100) NOT NULL,\n" + "	last_name varchar(100) NOT NULL,\n"
				+ "	CONSTRAINT Student_pk PRIMARY KEY (id)\n" + ")\n" + "ENGINE=InnoDB\n;";
		String createTeacherStudentTable = "CREATE TABLE IF NOT EXISTS maktab_schema.teacher_student (\n"
				+ "	id INT auto_increment NOT NULL,\n" + "	teacher_id INT NULL,\n" + "	student_id INT NULL,\n"
				+ "	CONSTRAINT teacher_student_pk PRIMARY KEY (id),\n"
				+ "	CONSTRAINT teacher_student_FK_student FOREIGN KEY (student_id) REFERENCES maktab_schema.student(id),\n"
				+ "	CONSTRAINT teacher_student_FK_teacher FOREIGN KEY (teacher_id) REFERENCES maktab_schema.teacher(id)\n"
				+ ")\n" + "ENGINE=InnoDB\n;";
		Connection connection = DbConnection.getConnection();
		Statement statement = connection.createStatement();
		statement.execute(createSchema);
		statement.execute(createStudenTable);
		statement.execute(createTeacherTable);
		statement.execute(createTeacherStudentTable);
	}
}
