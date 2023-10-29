package com.durgasoft.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.durgasoft.pojo.Employee;

public class SaveOrUpdateTest {

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
			tx = session.getTransaction();
			tx.begin();

			Employee emp1 = new Employee();
			emp1.setEmpID(333);
			emp1.setFirstName("CCC");
			emp1.setLastName("JJJ");
			emp1.setEsal(7000);
			emp1.setDesignation("Virtual Customer Care Support");

			session.saveOrUpdate(emp1);
			tx.commit();

			System.out.println("Employee Added/Updated Successfully!!!");

		} catch (Exception e) {
			tx.rollback();
			System.out.println("Employee Added/Updated Failure!!!");
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
