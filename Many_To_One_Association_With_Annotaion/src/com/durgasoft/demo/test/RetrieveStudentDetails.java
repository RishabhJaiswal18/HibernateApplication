package com.durgasoft.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durgasoft.demo.entity.Branch;
import com.durgasoft.demo.entity.Student;

public class RetrieveStudentDetails {

	public static void main(String[] args) {
		Configuration cfg = null;
		StandardServiceRegistryBuilder builder = null;
		StandardServiceRegistry registry = null;
		SessionFactory sf = null;
		Session session = null;

		try {
			cfg = new Configuration();
			cfg.addAnnotatedClass(Branch.class);
			cfg.addAnnotatedClass(Student.class);

			builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(cfg.getProperties());

			registry = builder.build();
			sf = cfg.buildSessionFactory(registry);

			session = sf.openSession();

			Student std = (Student) session.get(Student.class, "S-444");

			System.out.println("#### Searching Student Details ####");

			if (std != null) {
				System.out.println("#### Student Details Found ####");
				System.out.println("-------------------------------------");
				System.out.println("");
				System.out.println("Student Id : " + std.getSid());
				System.out.println("Student Name : " + std.getSname());
				System.out.println("Student Address : " + std.getSaddr());
				System.out.println("Branch Name : " + std.getBranch().getBname());
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("#### Student Details Not Found ####");
		} finally {
			session.close();
			sf.close();
		}
	}

}
