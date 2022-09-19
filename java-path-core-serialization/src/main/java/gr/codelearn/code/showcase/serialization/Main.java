package gr.codelearn.code.showcase.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import gr.codelearn.code.showcase.serialization.domain.Customer;
import gr.codelearn.code.showcase.serialization.domain.Directory;

public class Main {

	public static void main(String[] args) {
		Customer customer = new Customer("Ioannis D", "Athens", 2.50, new Date());
		writeCustomer(customer);

		Customer readCustomer = readCustomer();
		System.out.println(readCustomer);
	}

	private static void writeCustomer(Customer customer) {
		try (FileOutputStream fos = new FileOutputStream(Directory.FILE_DIRECTORY.getPath() + "customer.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(customer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Customer readCustomer() {
		Customer readCustomer = null; 
		try(FileInputStream fis = new FileInputStream(Directory.FILE_DIRECTORY.getPath() + "customer.txt");
				ObjectInputStream ois = new ObjectInputStream(fis)){
			readCustomer = (Customer) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return readCustomer;
	}

}
