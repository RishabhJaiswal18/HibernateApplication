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
			emp.setEmpId(4545);
			emp.setFirstName("Rishabh");
			emp.setLastName("Jaiswal");
			emp.setSalary(70000);
			emp.setDesignation("Sr. Software Developer");
			emp.setAddress("Delhi");
			emp.setEmpMobile("9760986348");

			int pk_value = (Integer) session.save(emp);
			tx.commit();
			if (pk_value == emp.getEmpId()) {
				System.out.println("#### Employee is inserted successfully !!!");
			} else {
				System.out.println("#### Employee insertion failure ####");
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
