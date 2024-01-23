package com.durgasoft.demo.entity;

import java.io.Serializable;
import java.util.Set;

public class Department implements Serializable {

	private String did;
	private String dname;
	private Set<Employee> emps;

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Set<Employee> getEmps() {
		return emps;
	}

	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + ", emps=" + emps + "]";
	}
}
