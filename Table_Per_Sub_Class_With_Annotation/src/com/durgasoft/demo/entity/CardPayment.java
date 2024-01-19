package com.durgasoft.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "card_payment")
@PrimaryKeyJoinColumn(name = "TX_ID")
public class CardPayment extends Payment implements Serializable {

	@Column(name = "card_number")
	private int cardNo;

	@Column(name = "exp_date")
	private String expDate;

	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "CardPayment [cardNo=" + cardNo + ", expDate=" + expDate + "]";
	}
}
