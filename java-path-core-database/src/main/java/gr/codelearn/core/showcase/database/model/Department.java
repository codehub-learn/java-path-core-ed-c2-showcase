package gr.codelearn.core.showcase.database.model;

public class Department {
	private Integer departmentId;
	private String name;
	private String uniName;
	
	public Department(String name, String uniName) {
		this.name = name;
		this.uniName = uniName;
	}
	
	public Department() {
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUniName() {
		return uniName;
	}
	public void setUniName(String uniName) {
		this.uniName = uniName;
	}

	
	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", name=" + name + ", uniName=" + uniName + "]";
	}

	
}
