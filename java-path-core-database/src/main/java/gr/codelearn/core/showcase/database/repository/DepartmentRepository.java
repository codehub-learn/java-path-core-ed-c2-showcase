package gr.codelearn.core.showcase.database.repository;

import java.util.List;

import gr.codelearn.core.showcase.database.model.Department;
import gr.codelearn.core.showcase.database.model.Student;

public interface DepartmentRepository {
	void createTable();
	void insert(Department department);
	List<Department> findAll();
	void dropTable();
	List<Student> findStudentdsWithDepartmentId(Integer id);
}
