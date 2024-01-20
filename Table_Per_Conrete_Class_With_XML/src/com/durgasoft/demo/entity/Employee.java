package com.durgasoft.demo.entity;

import java.io.Serializable;

public class Employee extends Person implements Serializable {
	
	private String eid;
	private float esal;

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

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", esal=" + esal + "]";
	}
}
