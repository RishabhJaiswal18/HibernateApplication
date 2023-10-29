package com.durgasoft.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.durgasoft.pojo.Employee;
import com.durgasoft.util.HibernateUtil;

public class EmployeeServiceImpl implements EmployeeService {

	Employee emp;

	public Employee search(int empNo) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			emp = (Employee) session.get(Employee.class, empNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
}
