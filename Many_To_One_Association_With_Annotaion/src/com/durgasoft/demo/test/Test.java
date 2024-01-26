package com.durgasoft.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durgasoft.demo.entity.Branch;
import com.durgasoft.demo.entity.Student;

public class Test {

	public static void main(String[] args) {
		Configuration cfg = null;
		StandardServiceRegistryBuilder builder = null;
		StandardServiceRegistry registry = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;

		try {
			cfg = new Configuration();
			cfg.addAnnotatedClass(Branch.class);
			cfg.addAnnotatedClass(Student.class);

			builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(cfg.getProperties());

			registry = builder.build();
			sf = cfg.buildSessionFactory(registry);

			session = sf.openSession();
			tx = session.beginTransaction();

//			Creating Branch Details
			Branch branch = new Branch();
			branch.setBid("B-222");
			branch.setBname("Information Technology & Engineering");

//			Creating Student Details
			Student std1 = new Student();
			std1.setSid("S-444");
			std1.setSname("DDD");
			std1.setSaddr("Delhi");
			std1.setBranch(branch);

			Student std2 = new Student();
			std2.setSid("S-555");
			std2.setSname("EEE");
			std2.setSaddr("Delhi");
			std2.setBranch(branch);

			Student std3 = new Student();
			std3.setSid("S-666");
			std3.setSname("FFF");
			std3.setSaddr("Delhi");
			std3.setBranch(branch);

			String std1_pk_value = (String) session.save(std1);
			String std2_pk_value = (String) session.save(std2);
			String std3_pk_value = (String) session.save(std3);

			if (std1_pk_value.equals(std1.getSid()) && std2_pk_value.equals(std2.getSid())
					&& std3_pk_value.equals(std3.getSid())) {
				tx.commit();
				System.out.println("#### Student Details Inserted Successfully ####");
			}

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			System.out.println("#### Student Details Insertion Failure ####");
		} finally {
			session.close();
			sf.close();
		}
	}
}
