package gr.codelearn.core.showcase.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Department {
	@Column
	private String name;
}
