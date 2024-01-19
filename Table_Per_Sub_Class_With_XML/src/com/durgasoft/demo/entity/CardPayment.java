package com.durgasoft.demo.entity;

import java.io.Serializable;

public class CardPayment extends Payment implements Serializable {

	private int cardNo;
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
