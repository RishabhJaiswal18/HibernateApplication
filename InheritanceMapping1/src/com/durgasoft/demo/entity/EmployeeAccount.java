package com.durgasoft.demo.entity;

import java.io.Serializable;

public class EmployeeAccount extends Account implements Serializable {

	private String eid;
	private float esal;
	private String eaddr;

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public float getEsal() {
		return esal;
	}

	public void setEsal(float esal) {
		this.esal = esal;
	}

	public String getEaddr() {
		return eaddr;
	}

	public void setEaddr(String eaddr) {
		this.eaddr = eaddr;
	}

	@Override
	public String toString() {
		return "EmployeeAccount [eid=" + eid + ", esal=" + esal + ", eaddr=" + eaddr + "]";
	}
}
