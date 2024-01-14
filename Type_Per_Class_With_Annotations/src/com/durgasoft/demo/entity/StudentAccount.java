package com.durgasoft.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("std")
public class StudentAccount extends Account implements Serializable {
	
	@Column(name = "std_id")
	private String sid;
	
	@Column(name = "std_branch")
	private String sbranch;
	
	@Column(name = "std_marks")
	private int smarks;

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSbranch() {
		return sbranch;
	}

	public void setSbranch(String sbranch) {
		this.sbranch = sbranch;
	}

	public int getSmarks() {
		return smarks;
	}

	public void setSmarks(int smarks) {
		this.smarks = smarks;
	}

	@Override
	public String toString() {
		return "StudentAccount [sid=" + sid + ", sbranch=" + sbranch + ", smarks=" + smarks + "]";
	}
}
