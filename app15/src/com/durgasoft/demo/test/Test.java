package com.durgasoft.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.durgasoft.demo.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		Configuration cfg = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;
		try {
			cfg = new Configuration();
			cfg.addAnnotatedClass(Employee.class);
			sf = cfg.buildSessionFactory();
			session = sf.openSession();
			tx = session.beginTransaction();

			Employee emp = new Employee();
			emp.setEmpId(8989);
			emp.setFirstName("III");
			emp.setLastName("GGG");
			emp.setSalary(6000);
			emp.setDesignation("Sarkari Majdoor");

			int pk_value = (Integer) session.save(emp);

			tx.commit();

			if (pk_value != 0) {
				System.out.println("### Employee Inserted Successfully ###");
			} else {
				System.out.println("### Employee Insertion Failure ###");
			}

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sf.close();
		}
	}

}
