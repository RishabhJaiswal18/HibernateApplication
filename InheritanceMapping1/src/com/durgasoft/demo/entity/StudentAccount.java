package com.durgasoft.demo.entity;

import java.io.Serializable;

public class StudentAccount extends Account implements Serializable {
	
	private String sid;
	private String sbranch;
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
