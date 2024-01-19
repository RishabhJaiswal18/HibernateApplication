package com.durgasoft.demo.entity;

import java.io.Serializable;

public class Payment implements Serializable {
	
	private String txId;
	private String payDate;
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
