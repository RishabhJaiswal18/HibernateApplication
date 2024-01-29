package com.durgasoft.demo.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durgasoft.demo.entity.Employee;

public class Non_Select_Bulk_Operation {

	public static void main(String[] args) {
		Configuration cfg = null;
		StandardServiceRegistryBuilder builder = null;
		StandardServiceRegistry registry = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;

		try {
			cfg = new Configuration();
			cfg.addAnnotatedClass(Employee.class);

			builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(cfg.getProperties());

			registry = builder.build();
			sf = cfg.buildSessionFactory(registry);

			session = sf.openSession();
			tx = session.beginTransaction();

			Query query = session.createQuery("update Employee set esal=esal+500 where esal<10000");

			int rowCount = query.executeUpdate();

			if (rowCount != 0) {
				tx.commit();
				System.out.println("Number of records updated : " + rowCount);
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
