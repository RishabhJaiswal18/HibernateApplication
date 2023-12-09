package com.durgasoft.test;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.durgasoft.pojo.Student;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
//			Configuration cfg = new AnnotationConfiguration();
			Configuration cfg = new Configuration();
			cfg.configure("/com/durgasoft/resources/hibernate.cfg.xml");

			sessionFactory = cfg.buildSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Student std1 = new Student();
			std1.setFirstName("AAA");
			std1.setLastName("ZZZ");
			std1.setAddress("Delhi");
			std1.setMarks(100);
			std1.setRollNo(34);
			std1.setSex("F");
			std1.setStandard("Play School");
			std1.setInsertionDate(new Date());
			std1.setInsertionTime(new Timestamp(System.currentTimeMillis()));

			int stdId = (Integer) session.save(std1);
			tx.commit();
			System.out.println(stdId);
			if (stdId != 0) {
				System.out.println("Student Record Inserted Successfully !!!");
			} else {
				System.out.println("Student Record Insertion Failure !!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
			session.close();
		}

	}

}
