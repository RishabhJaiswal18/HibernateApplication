package com.durgasoft.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.durgasoft.pojo.Employee;

public class Test {

	public static void main(String[] args) throws Exception {
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Employee emp = new Employee();
		emp.setEmpID(111);
		emp.setFirstName("AAA");
		emp.setLastName("ZZZ");
		emp.setEsal(5000);
		emp.setDesignation("Content Writer");

		int empno = (Integer) session.save(emp);
		tx.commit();
		System.out.println(empno);
		if (empno != 0) {
			System.out.println("Employee Inserted Successfully!!!");
		} else {
			System.out.println("Employee Insertion Failure!!!");
		}

		session.close();
		sessionFactory.close();
	}

}
