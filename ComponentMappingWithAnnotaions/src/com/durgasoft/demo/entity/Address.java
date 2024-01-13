package com.durgasoft.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Entity
@Embeddable
public class Address implements Serializable {

	@Column(name = "plot_number")
	private String pno;

	@Column(name = "street")
	private String street;

	@Column(name = "city")
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
