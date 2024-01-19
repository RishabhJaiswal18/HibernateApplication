package com.durgasoft.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durgasoft.demo.entity.CardPayment;
import com.durgasoft.demo.entity.ChequePayment;
import com.durgasoft.demo.entity.Payment;

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
//			cfg.addAnnotatedClass(Payment.class);
			cfg.addAnnotatedClass(CardPayment.class);
			cfg.addAnnotatedClass(ChequePayment.class);

			builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(cfg.getProperties());

			registry = builder.build();
			sf = cfg.buildSessionFactory(registry);

			session = sf.openSession();
			tx = session.beginTransaction();

//			Creating Card Payment
			CardPayment card_payment = new CardPayment();
			card_payment.setTxId("t-333");
			card_payment.setPayDate("12/12/2019");
			card_payment.setPayAmt(5000);
			card_payment.setCardNo(1234);
			card_payment.setExpDate("12/12/2024");

//			Creating Cheque Payment
			ChequePayment cheque_payment = new ChequePayment();
			cheque_payment.setTxId("t-444");
			cheque_payment.setPayDate("12/12/2019");
			cheque_payment.setPayAmt(10000);
			cheque_payment.setChequeNo(5678);
			cheque_payment.setAccNo("abc1234");

			String pk_val_1 = (String) session.save(card_payment);
			System.out.println("#### Card Payment Successfully ####");
			String pk_val_2 = (String) session.save(cheque_payment);
			System.out.println("#### Cheque Payment Successfully ####");

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			System.out.println("#### Payment Failure ####");
		} finally {
			session.close();
			sf.close();
		}
	}

}
