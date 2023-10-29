package com.durgasoft.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.durgasoft.pojo.Employee;

public class PersistTest {

	public static void main(String[] args) throws Exception {
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Employee emp1 = new Employee();
		emp1.setEmpID(222);
		emp1.setFirstName("BBB");
		emp1.setLastName("YYY");
		emp1.setEsal(6000);
		emp1.setDesignation("Customre Support");

		session.persist(emp1);
		tx.commit();

		System.out.println("Employee Added Successfully");

		session.close();
		sessionFactory.close();
	}

}
