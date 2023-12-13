package com.durgasoft.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.durgasoft.demo.model.Employee;

public class Test {

	public static void main(String[] args) {
		org.hibernate.cfg.Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			config = new Configuration();
			config.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
			config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/persons");
			config.setProperty("hibernate.connection.username", "root");
			config.setProperty("hibernate.connection.password", "root");
			config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			config.setProperty("hibernate.show_sql", "true");

			config.addAnnotatedClass(Employee.class);

			sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Employee emp = new Employee();
			emp.setEmpId(999);
			emp.setFirstName("HHH");
			emp.setLastName("GGG");
			emp.setSalary(5000);
			emp.setDesignation("Sarkari Majdoor");

			int pk_value = (Integer) session.save(emp);
			
			tx.commit();
			
			if (pk_value != 0) {
				System.out.println("#### Employee Insterted Successfully #####");
			} else {
				System.out.println("#### Employee Insertion Failure ####");
			}

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
