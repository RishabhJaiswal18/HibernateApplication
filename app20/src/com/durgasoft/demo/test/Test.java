package com.durgasoft.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durgasoft.demo.entity.Employee;

public class Test {

	public static void main(String[] args) {
		Configuration cfg = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;
		StandardServiceRegistryBuilder builder = null;
		StandardServiceRegistry registry = null;
		try {
			cfg = new Configuration();
			cfg.addAnnotatedClass(Employee.class);

			builder = new StandardServiceRegistryBuilder();
			builder.applySettings(cfg.getProperties());

			registry = builder.build();

			sf = cfg.buildSessionFactory(registry);
			session = sf.openSession();

			tx = session.beginTransaction();

			Employee emp = new Employee();
			emp.setEmpId(2525);
			emp.setFirstName("Shubham");
			emp.setLastName("Singh");
			emp.setSalary(35000);
			emp.setDesignation("Operation Expert");
			emp.setAddress("Gurgaon");
			emp.setEmpMobile("9689568956");

			int emp_pk_value = (Integer) session.save(emp);
			tx.commit();
			if (emp_pk_value == emp.getEmpId()) {
				System.out.println("#### Employee Record Inserted Successfully ####");
			} else {
				System.out.println("#### Employee Record Insertion Failure ####");
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
