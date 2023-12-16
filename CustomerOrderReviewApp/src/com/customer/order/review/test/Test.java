package com.customer.order.review.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.customer.order.review.pojo.CustomerModel;

public class Test {

	public static void main(String[] args) {
		Configuration cfg = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;
		try {
			cfg = new Configuration();
			cfg.addAnnotatedClass(CustomerModel.class);
			sf = cfg.buildSessionFactory();
			session = sf.openSession();
			tx = session.beginTransaction();

			CustomerModel cm = new CustomerModel();
			cm.setBrand("Punjabi Angithi By Vegorama Group");
			cm.setCustomerAddress("239, Mayur Vihar Phase 1, Delhi, India");
			cm.setCustomerContact("9760986348");
			cm.setCustomerId(Long.parseLong("5353917813"));
			cm.setCustomerName("Rishabh Jaiswal");
			cm.setCustomerProductOrder("Palak Paneer 500ML");
			cm.setProductPrice(Float.parseFloat("269.00"));
			cm.setCustomerRating("*****");

			long cm_pk_value = (Long) session.save(cm);

			tx.commit();

			if (cm_pk_value == cm.getCustomerId()) {
				System.out.println("### Customer Review Inserted Successfully ###");
			} else {
				System.out.println("#### Customer Review Insertion Failure ####");
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
