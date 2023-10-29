package com.durgasoft.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.durgasoft.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;

		try {
			config = new Configuration();
			config.configure("applicationContext.xml");
			sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Employee emp1 = new Employee();
			emp1.setEmpID(0);

			session.delete(emp1);

			tx.commit();
			System.out.println("Employee Deleted Successfully!!!");
		} catch (Exception e) {
			tx.rollback();
			System.out.println("Employee Deletion Failure!!!");
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
