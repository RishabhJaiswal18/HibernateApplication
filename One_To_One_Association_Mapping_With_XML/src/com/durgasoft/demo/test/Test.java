package com.durgasoft.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durgasoft.demo.entity.Account;
import com.durgasoft.demo.entity.Employee;

public abstract class Test {

	public static void main(String[] args) {
		Configuration cfg = null;
		StandardServiceRegistryBuilder builder = null;
		StandardServiceRegistry registry = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;

		try {
			cfg = new Configuration();
			cfg.addResource("com/durgasoft/demo/resources/Account.hbm.xml");
			cfg.addResource("com/durgasoft/demo/resources/Employee.hbm.xml");

			builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(cfg.getProperties());

			registry = builder.build();
			sf = cfg.buildSessionFactory(registry);

			session = sf.openSession();
			tx = session.beginTransaction();

//			Creating Account Details
			Account account = new Account();
			account.setAccNo("abc123");
			account.setAccName("Nagur Babu");
			account.setAccType("Savings");
			account.setBalance(10000);

//			Creating Employee Details
			Employee emp = new Employee();
			emp.setEno(111);
			emp.setEname("Naga Arjuna");
			emp.setEsal(5000);
			emp.setEaddr("Hyderabad");
			emp.setAcc(account);

			int emp_pk_val = (Integer) session.save(emp);

			if (emp_pk_val == emp.getEno()) {
				tx.commit();
				System.out.println("#### Employee Details Added Successfully ####");
			}

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			System.out.println("##### Insertion Faliure #####");
		} finally {
			session.close();
			sf.close();
		}
	}

}
