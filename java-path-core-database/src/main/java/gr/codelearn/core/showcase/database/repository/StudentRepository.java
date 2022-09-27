package gr.codelearn.core.showcase.database.repository;

import java.util.List;

import gr.codelearn.core.showcase.database.model.Student;

public interface StudentRepository {
	void createTable();
	void insert(Student student);
	List<Student> findAll();
	void dropTable();

}
