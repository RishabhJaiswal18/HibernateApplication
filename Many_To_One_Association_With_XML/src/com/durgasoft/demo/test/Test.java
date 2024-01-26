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
			cfg.addResource("com/durgasoft/demo/resources/Branch.hbm.xml");
			cfg.addResource("com/durgasoft/demo/resources/Student.hbm.xml");

			builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(cfg.getProperties());

			registry = builder.build();
			sf = cfg.buildSessionFactory(registry);

			session = sf.openSession();
			tx = session.beginTransaction();

//			Creating Branch Details
			Branch branch = new Branch();
			branch.setBid("B-111");
			branch.setBname("Computer Science & Engineering");

//			Creating Student Details
			Student std1 = new Student();
			std1.setSid("S-111");
			std1.setSname("AAA");
			std1.setSaddr("Delhi");
			std1.setBranch(branch);

			Student std2 = new Student();
			std2.setSid("S-222");
			std2.setSname("BBB");
			std2.setSaddr("Delhi");
			std2.setBranch(branch);

			Student std3 = new Student();
			std3.setSid("S-333");
			std3.setSname("CCC");
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
