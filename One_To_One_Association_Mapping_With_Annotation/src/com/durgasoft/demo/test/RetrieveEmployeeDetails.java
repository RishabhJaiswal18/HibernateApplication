package com.durgasoft.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durgasoft.demo.entity.Account;
import com.durgasoft.demo.entity.Employee;

public class RetrieveEmployeeDetails {

	public static void main(String[] args) {
		Configuration cfg = null;
		StandardServiceRegistryBuilder builder = null;
		StandardServiceRegistry registry = null;
		SessionFactory sf = null;
		Session session = null;

		try {
			cfg = new Configuration();
			cfg.addAnnotatedClass(Account.class);
			cfg.addAnnotatedClass(Employee.class);

			builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(cfg.getProperties());

			registry = builder.build();
			sf = cfg.buildSessionFactory(registry);

			session = sf.openSession();

			Employee emp = (Employee) session.get(Employee.class, 111);

			if (emp != null) {
				System.out.println("######### Employee Details #########");
				System.out.println("----------------------------------------");
				System.out.println("Employee Id : " + emp.getEno());
				System.out.println("Employee Name : " + emp.getEname());
				System.out.println("Employee Salary : " + emp.getEsal());
				System.out.println("Employee Address : " + emp.getEaddr());
				System.out.println("");
				System.out.println("######## Account Details ###########");
				System.out.println("-----------------------------------------");
				System.out.println("Account Number : " + emp.getAcc().getAccNo());
				System.out.println("Account Holder Name : " + emp.getAcc().getAccName());
				System.out.println("Account Type : " + emp.getAcc().getAccType());
				System.out.println("Balance : " + emp.getAcc().getBalance());
			} else {
				System.out.println("##### Employee Details Not Found ######");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
	}

}
