package com.project.my.homeworks.hw7.q1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	void addNewTeacher(Teacher teacher) throws SQLException {
		String sql = "INSERT INTO maktab_schema.teacher (id, first_name, last_name) VALUES(?, ?, ?);";
		Connection connection = DbConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, teacher.getId());
		statement.setString(2, teacher.getFirstName());
		statement.setString(3, teacher.getLastName());
		statement.execute();
	}

	boolean isDuplicateTeacherId(int id) throws SQLException {
		String sql = "SELECT id FROM maktab_schema.teacher WHERE id = ?;";
		Connection connection = DbConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet result = statement.executeQuery();
		return result.next();
	}
}
