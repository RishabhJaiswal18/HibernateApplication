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
			cfg.configure("/com/durgasoft/demo/resources/hibernate.cfg.xml");
			sf = cfg.buildSessionFactory();
			session = sf.openSession();
			tx = session.beginTransaction();

			Employee emp = new Employee();
			emp.setEmpId(5656);
			emp.setFirstName("LLL");
			emp.setLastName("III");
			emp.setSalary(70000);
			emp.setDesignation("Sr. Software Developer");

			session.save(emp);
			tx.commit();

			System.out.println("### Employee Insertion Successfull ###");

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sf.close();
			session.close();
		}
	}

}
