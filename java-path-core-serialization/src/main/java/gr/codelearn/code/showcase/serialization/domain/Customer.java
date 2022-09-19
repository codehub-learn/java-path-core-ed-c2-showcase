package gr.codelearn.code.showcase.serialization.domain;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
	
	private static final long serialVersionUID = 2;
	
	private String name;
	private String address;
	private double height;
	private Date dateOfBirth;
	
	public Customer(String name, String address, double height, Date dateOfBirth) {
		super();
		this.name = name;
		this.address = address;
		this.height = height;
		this.dateOfBirth = dateOfBirth;
	}


	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", height=" + height + ", dateOfBirth=" + dateOfBirth
				+ "]";
	}
	
	
}


