package com.durgasoft.demo.test;

import java.io.FileInputStream;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.durgasoft.demo.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		Configuration cfg = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;
		FileInputStream fis = null;
		Properties p = null;
		try {
			cfg = new Configuration();
			fis = new FileInputStream(
					"D:\\Core_Java_Durga\\HIbernate_Tutorial _By_Nagur_Babu_Practice\\app16\\src\\hibernate_xyz.properties");
			p = new Properties();
			p.load(fis);
			cfg.setProperties(p);

			cfg.addAnnotatedClass(Employee.class);
			sf = cfg.buildSessionFactory();
			session = sf.openSession();
			tx = session.beginTransaction();

			Employee emp = new Employee();
			emp.setEmpId(9898);
			emp.setFirstName("JJJ");
			emp.setLastName("III");
			emp.setSalary(6000);
			emp.setDesignation("Sarkari Majdoor");

			int pk_value = (Integer) session.save(emp);

			tx.commit();

			if (pk_value != 0) {
				System.out.println("#### Employee Inserted Successfully ####");
			} else {
				System.out.println("#### Employee Insertion Failure ####");
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
