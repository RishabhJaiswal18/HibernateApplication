package com.durgasoft.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.durgasoft.demo.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
//			config = new AnnotationConfiguration();
			config = new Configuration();
			config.configure("/com/durgasoft/demo/resources/hibernate.cfg.xml");
			sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Employee emp = new Employee();
			emp.setEmpId(555);
			emp.setFirstName("DDD");
			emp.setLastName("EEE");
			emp.setSalary(5000);
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
