package gr.codelearn.core.showcase.database.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gr.codelearn.core.showcase.database.model.Student;

public class StudentRepositoryImp implements StudentRepository {
	private Connection connection;

	public StudentRepositoryImp(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void createTable() {
		String sql = """
				create table if not exists student (
				studentId int not null AUTO_INCREMENT,
				name VARCHAR(20),
				email VARCHAR(20),
				age int,
				departmentId int not null,
				primary key(studentId),
				FOREIGN KEY(departmentId) REFERENCES department(departmentId) )
				""";
		try(Statement statement = connection.createStatement()){
			statement.executeUpdate(sql);
			System.out.println("-- Table student created");
		} catch (SQLException e) {
			System.out.println("An error occured. Details: " + e.getMessage());
		}

	}

	@Override
	public void insert(Student student) {
		String sql="""
				insert into student values
				(NULL,?,?,?,?)
				"""; 
		try(PreparedStatement prepareStatement = connection.prepareStatement(sql)){
			prepareStatement.setString(1, student.getName());
			prepareStatement.setString(2, student.getEmail());
			prepareStatement.setInt(3, student.getAge());
			prepareStatement.setInt(4, student.getDepartmentId());
			prepareStatement.executeUpdate();
			System.out.println("-- Created: "+ student);
		} catch (SQLException e) {
			System.out.println("An error occured. Details: " + e.getMessage());
		}
	}

	@Override
	public List<Student> findAll() {
		List<Student> students = new ArrayList<>();
		String sql = """
				select * from student
				""";
		try(Statement statement = connection.createStatement()){
			ResultSet resultSet = statement.executeQuery(sql);
			System.out.println("-- Retrieving all students");
			while(resultSet.next()) {
				Student student = new Student();
				student.setStudentId(resultSet.getInt("studentId"));
				student.setName(resultSet.getString("name"));
				student.setEmail(resultSet.getString("email"));
				student.setAge(resultSet.getInt("age"));
				student.setDepartmentId(resultSet.getInt("departmentId"));
				students.add(student);
			}
		} catch (SQLException e) {
			System.out.println("An error occured. Details: " + e.getMessage());
		}
		return students;
	}

	@Override
	public void dropTable() {
		String sql = """
				drop table student
				""";
		try(Statement statement = connection.createStatement()){
			statement.executeUpdate(sql);
			System.out.println("-- Table student deleted");
		} catch (SQLException e) {
			System.out.println("An error occured. Details: " + e.getMessage());
		}
	}
}
