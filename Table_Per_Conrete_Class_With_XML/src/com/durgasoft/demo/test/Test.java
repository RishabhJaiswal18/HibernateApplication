package com.durgasoft.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durgasoft.demo.entity.Customer;
import com.durgasoft.demo.entity.Employee;

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
			cfg.addResource("com/durgasoft/demo/resources/Person.hbm.xml");

			builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(cfg.getProperties());

			registry = builder.build();
			sf = cfg.buildSessionFactory(registry);

			session = sf.openSession();
			tx = session.beginTransaction();

//			Creating Employee Object
			Employee emp = new Employee();
			emp.setPname("Chenna Swami");
			emp.setPaddr("Chennai");
			emp.setEid("M23ER2024");
			emp.setEsal(50000);

//			Creating Customer Object
			Customer customer = new Customer();
			customer.setPname("Swami Plavam");
			customer.setPaddr("Hyderabad");
			customer.setCid("O123ER1724");
			customer.setCmobile("8545652346");

			String emp_pk_val = (String) session.save(emp);
			String customer_pk_val = (String) session.save(customer);

			if (emp_pk_val.equals(emp.getPname()) && customer_pk_val.equals(customer.getPname())) {
				tx.commit();
				System.out.println("#### Employee Details Inserted Successfully ####");
				System.out.println("#### Customer Details Inserted Successfully ####");
			}

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			System.out.println("#### Employee Or Customer Details Insertion Failure ####");
		} finally {
			session.close();
			sf.close();
		}
	}

}
