package com.durgasoft.demo.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durgasoft.demo.entity.Employee;
import com.durgasoft.demo.entity.Employee1;

public class Inserting_One_Table_Data_To_Another_Table {

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
			cfg.addAnnotatedClass(Employee1.class);

			builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(cfg.getProperties());

			registry = builder.build();
			sf = cfg.buildSessionFactory(registry);

			session = sf.openSession();
			tx = session.beginTransaction();

			Query query = session.createQuery(
					"insert into Employee1(eno,ename,esal,eaddr)select e.eno,e.ename,e.esal,e.eaddr from Employee as e");

			int rowCount = query.executeUpdate();

			if (rowCount != 0) {
				tx.commit();
				System.out.println("Number of Records inserted = " + rowCount);
			}

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			System.out.println("Table Insertion Failure");
		} finally {
			session.close();
			sf.close();
		}
	}

}
