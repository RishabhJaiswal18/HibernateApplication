package com.durgasoft.demo.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durgasoft.demo.entity.Department;
import com.durgasoft.demo.entity.Employee;

public class RetrievalValueFromDatabase {

	public static void main(String[] args) {
		Configuration cfg = null;
		StandardServiceRegistryBuilder builder = null;
		StandardServiceRegistry registry = null;
		SessionFactory sf = null;
		Session session = null;

		try {
			cfg = new Configuration();
			cfg.addAnnotatedClass(Employee.class);
			cfg.addAnnotatedClass(Department.class);

			builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(cfg.getProperties());

			registry = builder.build();
			sf = cfg.buildSessionFactory(registry);

			session = sf.openSession();

			Department dept = (Department) session.get(Department.class, "D-333");
			System.out.println("#### Department Details ####");
			System.out.println("---------------------------------------");
			System.out.println("Department Id : " + dept.getDid());
			System.out.println("Department Name : " + dept.getDname());
			System.out.println();
			System.out.println("#### Employee Details ####");
			System.out.println("---------------------------------------");
			Set<Employee> emps = dept.getEmps();
			for (Employee emp : emps) {
				System.out.println("Employee Number : " + emp.getEno());
				System.out.println("Employee Name : " + emp.getEname());
				System.out.println("Employee Salary : " + emp.getEsal());
				System.out.println("Employee Address : " + emp.getEaddr());
				System.out.println("");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
	}

}
