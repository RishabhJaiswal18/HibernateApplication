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
			config.configure();
			sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();

			tx = session.getTransaction(); // for customize start of transaction
			tx.begin();
			Employee emp1 = new Employee();
			emp1.setEmpID(0);
			emp1.setFirstName("XXX");
			emp1.setLastName("BBB");
			emp1.setEsal(8000);
			emp1.setDesignation("Virtual Support");

			session.update(emp1);
			tx.commit();
			System.out.println("Employee Updated Successfully!!!");

		} catch (Exception e) {
			tx.rollback();
			System.out.println("Employee Updation Failure");
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
