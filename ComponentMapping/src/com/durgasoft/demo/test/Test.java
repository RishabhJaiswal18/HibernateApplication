package com.durgasoft.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durgasoft.demo.entity.Account;
import com.durgasoft.demo.entity.Address;
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
			cfg.addResource("com/durgasoft/demo/resources/Employee.hbm.xml");

			builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(cfg.getProperties());

			registry = builder.build();

			sf = cfg.buildSessionFactory(registry);
			session = sf.openSession();

			tx = session.beginTransaction();

//			Creating Account Details
			Account account = new Account();
			account.setAccName("BBB");
			account.setAccNo("abc123");
			account.setAccType("Saving");

//			Creating Address Details 
			Address address = new Address();
			address.setPno("23/3rt");
			address.setStreet("MGRoad");
			address.setCity("Hyderabad");

//			Creating Employee Details
			Employee emp = new Employee();
//			emp.setEno(111);
			emp.setEname("BBB");
			emp.setEsal(5000);
			emp.setAddr(address);
			emp.setAcc(account);

			int pk_value = (Integer) session.save(emp);

			if (pk_value == emp.getEno()) {
				tx.commit();
				System.out.println("!!!! Employee Details Inserted Successfully !!!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("!!!! Employee Insertion Failure !!!!");
			tx.rollback();
		} finally {
			session.close();
			sf.close();
		}
	}

}
