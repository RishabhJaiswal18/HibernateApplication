package com.durgasoft.demo.entity;

import java.io.Serializable;

public class Customer extends Person implements Serializable {
	
	private String cid;
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
