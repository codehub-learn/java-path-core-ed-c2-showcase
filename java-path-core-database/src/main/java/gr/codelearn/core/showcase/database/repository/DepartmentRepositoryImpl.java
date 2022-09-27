package gr.codelearn.core.showcase.database.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gr.codelearn.core.showcase.database.JDBCConnection;
import gr.codelearn.core.showcase.database.model.Department;
import gr.codelearn.core.showcase.database.model.Student;

public class DepartmentRepositoryImpl implements DepartmentRepository {
	private Connection connection;

	public DepartmentRepositoryImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void createTable() {
		String sql = """
				create table if not exists department (
				departmentId int not null AUTO_INCREMENT,
				name VARCHAR(20),
				uniName VARCHAR(20),
				primary key(departmentId))
				""";
		try (Statement statement = connection.createStatement()) {
			statement.executeUpdate(sql);
			System.out.println("-- Table department created");
		} catch (SQLException e) {
			System.out.println("An error occured. Details: " + e.getMessage());
		}
	}

	@Override
	public void insert(Department department) {
		String sql = """
				insert into department (name,uniName) values
				(?,?)
				""";
		try(PreparedStatement prepareStatement = connection.prepareStatement(sql)){
			prepareStatement.setString(1,department.getName());
			prepareStatement.setString(2, department.getUniName());
			prepareStatement.executeUpdate();
			System.out.println("-- Created: "+ department);
		} catch (SQLException e) {
			System.out.println("An error occured. Details: " + e.getMessage());
		}
	}

	@Override
	public List<Department> findAll() {
		List<Department> departments = new ArrayList<>();
		String sql = """
				select * from department
				""";
		try(Statement statement = connection.createStatement()){
			ResultSet resultSet = statement.executeQuery(sql);
			System.out.println("-- Retrieving all departments");
			while(resultSet.next()) {
				Department department = new Department();
				department.setDepartmentId(resultSet.getInt("departmentId"));
				department.setName(resultSet.getString("name"));
				department.setUniName(resultSet.getString("uniName"));
				departments.add(department);
			}
		} catch (SQLException e) {
			System.out.println("An error occured. Details: " + e.getMessage());
		}
		return departments;
	}

	@Override
	public void dropTable() {
		String sql = """
				drop table department
				""";
		try (Statement statement = connection.createStatement()) {
			statement.executeUpdate(sql);
			System.out.println("-- Table department deleted");
		} catch (SQLException e) {
			System.out.println("An error occured. Details: " + e.getMessage());
		}
		
	}

	@Override
	public List<Student> findStudentdsWithDepartmentId(Integer id) {
		List<Student> students = new ArrayList<>();
		String sql="""
				select student.name , student.email from department
				inner join student on (department.departmentId = student.departmentId)
				where department.departmentId = ?
				""";
		try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println("-- Retrieving all students for department with id: "+id);
			while(resultSet.next()) {
				Student student = new Student();
				student.setName(resultSet.getString("name"));
				student.setEmail(resultSet.getString("email"));
				students.add(student);
			}
		} catch (SQLException e) {
			System.out.println("An error occured. Details: " + e.getMessage());
		}
		return students;
	}

}
