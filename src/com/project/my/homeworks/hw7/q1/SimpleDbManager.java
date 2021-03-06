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
				+ "	CONSTRAINT teacher_student_FK_student FOREIGN KEY (student_id) REFERENCES maktab_schema.student(id) ON DELETE CASCADE ON UPDATE CASCADE,\n"
				+ "	CONSTRAINT teacher_student_FK_teacher FOREIGN KEY (teacher_id) REFERENCES maktab_schema.teacher(id) ON DELETE CASCADE ON UPDATE CASCADE\n"
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

	void updateTeacher(Teacher teacher) throws SQLException {
		String sql = "UPDATE maktab_schema.teacher SET first_name=?, last_name=? WHERE id=?;";
		Connection connection = DbConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, teacher.getFirstName());
		statement.setString(2, teacher.getLastName());
		statement.setInt(3, teacher.getId());
		statement.execute();
	}

	public void removeTeacherById(int id) throws SQLException {
		String sql = "DELETE FROM maktab_schema.teacher WHERE id=?;";
		Connection connection = DbConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		statement.execute();

	}

	public String fetchAllTeachers() throws SQLException {
		StringBuilder result = new StringBuilder();
		String sql = "SELECT id, first_name, last_name FROM maktab_schema.teacher;";
		Connection connection = DbConnection.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		Teacher teacher = null;
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String firstName = resultSet.getString("first_name");
			String lastName = resultSet.getString("last_name");
			teacher = new Teacher(id, firstName, lastName);
			if (result.isEmpty() == false)
				result.append(System.lineSeparator());
			result.append(" -" +teacher.toString());
		}

		return result.toString();
	}

	void addNewStudent(Student student) throws SQLException {
		String sql = "INSERT INTO maktab_schema.student (id, first_name, last_name) VALUES(?, ?, ?);";
		Connection connection = DbConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, student.getId());
		statement.setString(2, student.getFirstName());
		statement.setString(3, student.getLastName());
		statement.execute();
	}

	boolean isDuplicateStudentId(int id) throws SQLException {
		String sql = "SELECT id FROM maktab_schema.student WHERE id = ?;";
		Connection connection = DbConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet result = statement.executeQuery();
		return result.next();
	}

	void updateStudent(Student student) throws SQLException {
		String sql = "UPDATE maktab_schema.student SET first_name=?, last_name=? WHERE id=?;";
		Connection connection = DbConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, student.getFirstName());
		statement.setString(2, student.getLastName());
		statement.setInt(3, student.getId());
		statement.execute();
	}

	public void removeStudentById(int id) throws SQLException {
		String sql = "DELETE FROM maktab_schema.student WHERE id=?;";
		Connection connection = DbConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		statement.execute();

	}

	public String fetchAllStudents() throws SQLException {
		StringBuilder result = new StringBuilder();
		String sql = "SELECT id, first_name, last_name FROM maktab_schema.student;";
		Connection connection = DbConnection.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		Student student = null;
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String firstName = resultSet.getString("first_name");
			String lastName = resultSet.getString("last_name");
			student = new Student(id, firstName, lastName);
			if (result.isEmpty() == false)
				result.append(System.lineSeparator());
			result.append(" -" +student.toString());
		}

		return result.toString();
	}

	public boolean isStudentAssignedForTeacher(int teacherId, int studentId) throws SQLException {
		String sql = "SELECT id FROM maktab_schema.teacher_student WHERE teacher_id=? AND student_id=?;";
		Connection connection = DbConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, teacherId);
		statement.setInt(2, studentId);
		ResultSet result = statement.executeQuery();
		return result.next();

	}

	public void assignStudentForTeacher(int teacherId, int studentId) throws SQLException {
		String sql = "INSERT INTO maktab_schema.teacher_student (teacher_id, student_id) VALUES(?, ?);";
		Connection connection = DbConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, teacherId);
		statement.setInt(2, studentId);
		statement.execute();
	}

	public void removeStudentOfTeacher(int teacherId, int studentId) throws SQLException {
		String sql = "DELETE FROM maktab_schema.teacher_student WHERE teacher_id=? AND student_id=?;";
		Connection connection = DbConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, teacherId);
		statement.setInt(2, studentId);
		statement.execute();
	}

	public String fetchAllTeachersStudents(int teacherId) throws SQLException {
		StringBuilder result = new StringBuilder();
		String sql = "SELECT * FROM maktab_schema.student s"
				+ " WHERE s.id IN (SELECT ts.student_id FROM maktab_schema.teacher_student ts, maktab_schema.teacher t"
				+ " WHERE t.id = ts.teacher_id AND ts.teacher_id=? );";
		Connection connection = DbConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, teacherId);
		ResultSet resultSet = statement.executeQuery();
		Student student = null;
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String firstName = resultSet.getString("first_name");
			String lastName = resultSet.getString("last_name");
			student = new Student(id, firstName, lastName);
			if (result.isEmpty() == false)
				result.append(System.lineSeparator());
			result.append(" -" + student.toString());
		}

		return result.toString();
	}

	public String fetchAllStudentsTeachers(int studentId) throws SQLException {
		StringBuilder result = new StringBuilder();
		String sql = "SELECT * FROM maktab_schema.teacher t"
				+ " WHERE t.id IN (SELECT ts.teacher_id FROM maktab_schema.teacher_student ts, maktab_schema.student s"
				+ " WHERE s.id = ts.student_id AND ts.student_id=? );";
		Connection connection = DbConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, studentId);
		ResultSet resultSet = statement.executeQuery();
		Teacher teacher = null;
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String firstName = resultSet.getString("first_name");
			String lastName = resultSet.getString("last_name");
			teacher = new Teacher(id, firstName, lastName);
			if (result.isEmpty() == false)
				result.append(System.lineSeparator());
			result.append(" -" + teacher.toString());
		}

		return result.toString();
	}
}
