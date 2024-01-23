package com.durgasoft.demo.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durgasoft.demo.entity.Department;
import com.durgasoft.demo.entity.Employee;

public class Test {

	public static void main(String[] args) {
		Configuration cfg = null;
		StandardServiceRegistryBuilder builder = null;
		StandardServiceRegistry registry = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;
		Employee emp1, emp2, emp3;

		try {
			cfg = new Configuration();
			cfg.addResource("com/durgasoft/demo/resources/Department.hbm.xml");
			cfg.addResource("com/durgasoft/demo/resources/Employee.hbm.xml");

			builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(cfg.getProperties());

			registry = builder.build();
			sf = cfg.buildSessionFactory(registry);

			session = sf.openSession();
			tx = session.beginTransaction();

//			Creating Employee Details

			emp1 = new Employee();
			emp1.setEno(444);
			emp1.setEname("DDD");
			emp1.setEsal(5000);
			emp1.setEaddr("Delhi");

			emp2 = new Employee();
			emp2.setEno(555);
			emp2.setEname("EEE");
			emp2.setEsal(6000);
			emp2.setEaddr("Delhi");

			emp3 = new Employee();
			emp3.setEno(666);
			emp3.setEname("FFF");
			emp3.setEsal(7000);
			emp3.setEaddr("Delhi");

			Set<Employee> emps = new HashSet<>();
			emps.add(emp1);
			emps.add(emp2);
			emps.add(emp3);

//			Creating Department Details
			Department department = new Department();
			department.setDid("D-222");
			department.setDname("Admin");
			department.setEmps(emps);

			String dept_pk_val = (String) session.save(department);

			if (dept_pk_val.equals(department.getDid())) {
				tx.commit();
				System.out.println("Department = " + dept_pk_val + " inserted Successfully !!!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			System.out.println("Department insertion failure !!!");
		} finally {
			session.close();
			sf.close();
		}
	}

}
