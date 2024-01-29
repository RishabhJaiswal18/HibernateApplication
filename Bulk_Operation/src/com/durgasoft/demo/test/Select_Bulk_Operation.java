package com.durgasoft.demo.test;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durgasoft.demo.entity.Employee;

public class Select_Bulk_Operation {

	public static void main(String[] args) {
		Configuration cfg = null;
		StandardServiceRegistryBuilder builder = null;
		StandardServiceRegistry registry = null;
		SessionFactory sf = null;
		Session session = null;

		try {
			cfg = new Configuration();
			cfg.addAnnotatedClass(Employee.class);

			builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(cfg.getProperties());

			registry = builder.build();
			sf = cfg.buildSessionFactory(registry);

			session = sf.openSession();

			Query hql_query = session.createQuery("from Employee");

//			Please uncomment the operations which you want to perform

//			By using list() methods

//			List<Employee> list = hql_query.list();
//
//			System.out.println("#### Using list() method ####");
//
//			if (list != null && !list.isEmpty()) {
//				System.out.println("Searching Employees Records ....");
//				Thread.sleep(5000);
//				System.out.println("------------------------------------");
//				System.out.println("");
//				for (Employee emp : list) {
//					System.out.println("Employee Number : " + emp.getEno());
//					System.out.println("Employee Name : " + emp.getEname());
//					System.out.println("Employee Salary : " + emp.getEsal());
//					System.out.println("Employee Address : " + emp.getEaddr());
//					System.out.println("");
//				}
//			}

//			By using iterate() method
//			Iterator<Employee> itr = hql_query.iterate();
//			System.out.println("#### Using iterate() method ####");
//			System.out.println("Searching Employees Records ....");
//			Thread.sleep(5000);
//			System.out.println("------------------------------------");
//			System.out.println("");
//			while (itr.hasNext()) {
//				Employee emp = itr.next();
//				System.out.println("Employee Number : " + emp.getEno());
//				System.out.println("Employee Name : " + emp.getEname());
//				System.out.println("Employee Salary : " + emp.getEsal());
//				System.out.println("Employee Address : " + emp.getEaddr());
//				System.out.println("");
//			}

//			By using scroll() method

//			ScrollableResults result = hql_query.scroll();
//			System.out.println("#### Using scroll() method ####");
//			System.out.println("Searching Employees Records ....");
//			Thread.sleep(5000);
//			System.out.println("------------------------------------");
//			System.out.println("");

//			For Traversing forward direction
//			while (result.next()) {
//				Object[] obj = result.get();
//				for (Object o : obj) {
//					Employee emp = (Employee) o;
//					System.out.println("Employee Number : " + emp.getEno());
//					System.out.println("Employee Name : " + emp.getEname());
//					System.out.println("Employee Salary : " + emp.getEsal());
//					System.out.println("Employee Address : " + emp.getEaddr());
//					System.out.println("");
//				}
//			}

//			For Traversing Backward Direction
//			result.afterLast(); // this is used to make cursor to the after last element
//			while (result.previous()) {
//				Object[] obj = result.get();
//				for (Object o : obj) {
//					Employee emp = (Employee) o;
//					System.out.println("Employee Number : " + emp.getEno());
//					System.out.println("Employee Name : " + emp.getEname());
//					System.out.println("Employee Salary : " + emp.getEsal());
//					System.out.println("Employee Address : " + emp.getEaddr());
//					System.out.println("");
//				}
//			}

//			By using uniqueResult() method

//			This only work for single record if multiple record present in database then it throws exception
//			saying query did not return a unique result : (no. of multiple results)
//			Employee emp = (Employee) hql_query.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
	}

}
