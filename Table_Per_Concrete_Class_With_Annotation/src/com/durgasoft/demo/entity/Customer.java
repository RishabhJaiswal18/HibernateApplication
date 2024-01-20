package com.durgasoft.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer extends Person implements Serializable {

	@Column(name = "c_id")
	private String cid;

	@Column(name = "mobile")
	private String cmobile;

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCmobile() {
		return cmobile;
	}

	public void setCmobile(String cmobile) {
		this.cmobile = cmobile;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cmobile=" + cmobile + "]";
	}
}
