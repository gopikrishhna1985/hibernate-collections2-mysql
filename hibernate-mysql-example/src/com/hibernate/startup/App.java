package com.hibernate.startup;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Student student1 = new Student();
		student1.setStudentName("John");
		student1.setAdmissionDate(new Date());
		student1.setSection("VI");
		student1.setStudentDesc("John is a wonderful student, and also a class topper!!!");

		Address addr1 = new Address();
		addr1.setCity("NewYork");
		addr1.setState("NY");
		addr1.setStreet("Lexington Ave");
		addr1.setZipCode("10023");
		student1.getAddressCollection().add(addr1);

		Student student2 = new Student();
		student2.setStudentName("Mary");
		student2.setAdmissionDate(new Date());
		student2.setSection("V");
		student2.setStudentDesc("Mary is a good girl");

		Address addr2 = new Address();
		addr2.setCity("NewYork");
		addr2.setState("NY");
		addr2.setStreet("Time Square");
		addr2.setZipCode("06010");
		student2.getAddressCollection().add(addr2);
		
		Address addr3 = new Address();
		addr3.setCity("Los Angeles");
		addr3.setState("CA");
		addr3.setStreet("Maximus Square");
		addr3.setZipCode("90001");
		student2.getAddressCollection().add(addr3);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(student1);
		session.save(student2);
		session.getTransaction().commit();
		session.close();

		/*
		 * session = sessionFactory.openSession(); session.beginTransaction();
		 * Student obj = (Student) session.get(Student.class, 100);
		 * System.out.println(obj.toString());
		 */
	}
}
