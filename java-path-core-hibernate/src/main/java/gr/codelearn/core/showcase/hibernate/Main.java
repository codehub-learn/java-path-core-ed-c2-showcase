package gr.codelearn.core.showcase.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import gr.codelearn.core.showcase.hibernate.model.Department;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("UniversityModule");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Department department = new Department("Computer Science");
		entityManager.getTransaction().begin();
		entityManager.persist(department);
		entityManager.getTransaction().commit();
		entityManagerFactory.close();
	}
}
