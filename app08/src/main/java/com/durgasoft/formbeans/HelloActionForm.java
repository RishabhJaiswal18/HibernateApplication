package com.durgasoft.formbeans;

import com.opensymphony.xwork2.ActionSupport;

public class HelloActionForm extends ActionSupport {

	private String uname;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "wish";
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}
}
