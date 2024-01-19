package com.durgasoft.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "payment_details")
@Inheritance(strategy = InheritanceType.JOINED)
public class Payment implements Serializable {

	@Id
	@Column(name = "tx_id")
	private String txId;

	@Column(name = "pay_date")
	private String payDate;

	@Column(name = "pay_amt")
	private int payAmt;

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public int getPayAmt() {
		return payAmt;
	}

	public void setPayAmt(int payAmt) {
		this.payAmt = payAmt;
	}

	@Override
	public String toString() {
		return "Payment [txId=" + txId + ", payDate=" + payDate + ", payAmt=" + payAmt + "]";
	}
}
