package com.durgasoft.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cheque_payment")
@PrimaryKeyJoinColumn(name = "TX_ID")
public class ChequePayment extends Payment implements Serializable {
	
	@Column(name = "cheque_number")
	private int chequeNo;
	
	@Column(name = "account_number")
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
