package com.durgasoft.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.durgasoft.demo.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		Configuration cfg = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			cfg = new Configuration();
			cfg.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
			cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/persons");
			cfg.setProperty("hibernate.connection.username", "root");
			cfg.setProperty("hibernate.connection.password", "root");
			cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			cfg.setProperty("hibernate.show_sql", "true");

			cfg.addResource("com/durgasoft/demo/resources/Employee.hbm.xml");

			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Employee emp = new Employee();
			emp.setEmpId(888);
			emp.setFirstName("FFF");
			emp.setLastName("GGG");
			emp.setSalary(9000);
			emp.setDesignation("Majdoor");

			int pk_value = (Integer) session.save(emp);

			tx.commit();

			if (pk_value != 0) {
				System.out.println("#### Employee Inserted Successfully ####");
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
