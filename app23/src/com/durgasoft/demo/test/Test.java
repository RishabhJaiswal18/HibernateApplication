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
		StandardServiceRegistryBuilder builder = null;
		StandardServiceRegistry registry = null;
		Transaction tx = null;

		try {
			cfg = new Configuration();
			cfg.configure("/com/durgasoft/demo/resources/hibernate.cfg.xml");

			builder = new StandardServiceRegistryBuilder();
			builder.applySettings(cfg.getProperties());

			registry = builder.build();
			sf = cfg.buildSessionFactory(registry);
			session = sf.openSession();

			tx = session.beginTransaction();

			Employee emp = new Employee();
//			emp.setEmpId(1414);
			emp.setFirstName("Teri He");
			emp.setLastName("Galiyon Main");
			emp.setSalary(35000);
			emp.setDesignation("Artist");
			emp.setAddress("Gurgaon");
			emp.setEmpMobile("9689568956");

			int pk_value = (Integer) session.save(emp);

			tx.commit();

			if (pk_value == emp.getEmpId()) {
				System.out.println("#### Employee Insertion Successfull ####");
			} else {
				System.out.println("#### Employee Insertion Failure ####");
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
