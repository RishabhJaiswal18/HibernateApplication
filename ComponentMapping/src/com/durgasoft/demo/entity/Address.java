package com.durgasoft.demo.entity;

import java.io.Serializable;

public class Address implements Serializable {
	
	private String pno;
	private String street;
	private String city;

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [pno=" + pno + ", street=" + street + ", city=" + city + "]";
	}
}
