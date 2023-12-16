package com.durgasoft.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durgasoft.demo.entity.Employee;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Configuration cfg = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;
		try {
			cfg = new Configuration();
			cfg.configure("/com/durgasoft/demo/resources/hibernate.cfg.xml");

			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(cfg.getProperties());

			StandardServiceRegistry registry = builder.build();

			sf = cfg.buildSessionFactory(registry);

			session = sf.openSession();
			tx = session.beginTransaction();

			Employee emp = new Employee();
			emp.setEmpId(3535);
			emp.setFirstName("Ankul");
			emp.setLastName("Jaiswal");
			emp.setSalary(70000);
			emp.setDesignation("Sr. Software Developer");
			emp.setAddress("Delhi");
			emp.setEmpMobile("9453039364");

			int emp_pk_value = (Integer) session.save(emp);

			tx.commit();

			if (emp_pk_value == emp.getEmpId()) {
				System.out.println("#### Employee Registered Successfully!!!");
			} else {
				System.out.println("#### Employee Registration Failure ####");
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
