package com.durgasoft.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durgasoft.demo.entity.Account;
import com.durgasoft.demo.entity.EmployeeAccount;
import com.durgasoft.demo.entity.StudentAccount;

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
			cfg.addAnnotatedClass(StudentAccount.class);
			cfg.addAnnotatedClass(EmployeeAccount.class);

			builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(cfg.getProperties());

			registry = builder.build();
			sf = cfg.buildSessionFactory(registry);

			session = sf.openSession();
			tx = session.beginTransaction();

//			Create Student Account Details

			StudentAccount std = new StudentAccount();
			std.setAccNo("a-444");
			std.setAccName("EEE");
			std.setAccType("Savings");
			std.setSid("s-444");
			std.setSbranch("Computer Science");
			std.setSmarks(95);

//			Create Employee Account Details
			EmployeeAccount emp = new EmployeeAccount();
			emp.setAccNo("a-555");
			emp.setAccName("FFF");
			emp.setAccType("Savings");
			emp.setEid("e-555");
			emp.setEaddr("Delhi");
			emp.setEsal(15000);

			String std_pk_value = (String) session.save(std);
			String emp_pk_value = (String) session.save(emp);

			if (std_pk_value.equalsIgnoreCase(std.getAccNo()) && emp_pk_value.equalsIgnoreCase(emp.getAccNo())) {
				tx.commit();
				System.out.println("##### Student Account Registered Successfully #####");
				System.out.println("##### Employee Account Registered Successfully #####");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("##### Insertion Failure #####");
			tx.rollback();
		} finally {
			session.close();
			sf.close();
		}
	}

}
