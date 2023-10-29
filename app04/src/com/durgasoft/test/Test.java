package com.durgasoft.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.durgasoft.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;

		try {
			config = new Configuration();
			config.configure("/com/durgasoft/resources/applicationContext.xml");
			sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();

			Employee emp1 = (Employee) session.get(Employee.class, 111);
			System.out.println("##### Employee Details ######");
			System.out.println("EmpId \t First Name \t Last Name \t Salary \t Designation");
			System.out.println("------------------------------------------------------------------------------");
			if (emp1 != null) {
				System.out.println(emp1.getEmpID() + "\t" + emp1.getFirstName() + "\t\t" + emp1.getLastName() + "\t\t"
						+ emp1.getEsal() + "\t\t" + emp1.getDesignation());
			} else {
				System.out.println("Data Not Found !!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
