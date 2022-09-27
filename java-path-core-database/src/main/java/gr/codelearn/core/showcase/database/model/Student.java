package gr.codelearn.core.showcase.database.model;

public class Student {
	private Integer studentId;
	private String name;
	private String email;
	private Integer age;
	private Integer departmentId;
	
	public Student(String name, String email, Integer age, Integer departmentId) {
		this.name = name;
		this.email = email;
		this.age = age;
		this.departmentId = departmentId;
	}

	public Student() {
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", email=" + email + ", age=" + age
				+ ", departmentId=" + departmentId + "]";
	}
	
	
}
