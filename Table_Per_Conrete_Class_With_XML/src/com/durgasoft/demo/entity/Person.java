package com.durgasoft.demo.entity;

import java.io.Serializable;

public class Person implements Serializable {
	
	private String pname;
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
