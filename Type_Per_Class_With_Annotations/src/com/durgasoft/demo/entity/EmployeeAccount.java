package com.durgasoft.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("emp")
public class EmployeeAccount extends Account implements Serializable {

	@Column(name = "emp_id")
	private String eid;

	@Column(name = "emp_salary")
	private float esal;

	@Column(name = "emp_address")
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
