package com.durgasoft.demo.entity;

import java.io.Serializable;

public class ChequePayment extends Payment implements Serializable {
	
	private int chequeNo;
	private String accNo;

	public int getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(int chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	@Override
	public String toString() {
		return "ChequePayment [chequeNo=" + chequeNo + ", accNo=" + accNo + "]";
	}
}
