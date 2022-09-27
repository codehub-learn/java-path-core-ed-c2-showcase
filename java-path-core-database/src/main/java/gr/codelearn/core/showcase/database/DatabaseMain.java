package gr.codelearn.core.showcase.database;

import java.sql.Connection;

import gr.codelearn.core.showcase.database.model.Department;
import gr.codelearn.core.showcase.database.model.Student;
import gr.codelearn.core.showcase.database.repository.DepartmentRepository;
import gr.codelearn.core.showcase.database.repository.DepartmentRepositoryImpl;
import gr.codelearn.core.showcase.database.repository.StudentRepository;
import gr.codelearn.core.showcase.database.repository.StudentRepositoryImp;

public class DatabaseMain {
	public static void main(String[] args) {
		Connection connection = JDBCConnection.getConnection();
		DepartmentRepository departmentRepository = new DepartmentRepositoryImpl(connection);
		departmentRepository.createTable();
		departmentRepository.insert(new Department("Computer Science","MIT"));
		departmentRepository.insert(new Department("Economics","OPA"));
		departmentRepository.findAll().forEach(System.out::println);
		
		StudentRepository studentRepository = new StudentRepositoryImp(connection);
		studentRepository.createTable();
		studentRepository.insert(new Student("Thor","thor@hammer.gr",100,1));
		studentRepository.insert(new Student("Ironman","iron@man.gr",60,2));
		studentRepository.findAll().forEach(System.out::println);
		
		departmentRepository.findStudentdsWithDepartmentId(1).forEach(System.out::println);
		
		studentRepository.dropTable();
		departmentRepository.dropTable();
		
	}

}
