package com.durgasoft.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person implements Serializable {

	@Id
	@Column(name = "name")
	private String pname;

	@Column(name = "address")
	private String paddr;

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPaddr() {
		return paddr;
	}

	public void setPaddr(String paddr) {
		this.paddr = paddr;
	}

	@Override
	public String toString() {
		return "Person [pname=" + pname + ", paddr=" + paddr + "]";
	}
}
