package com.durgasoft.factory;

import com.durgasoft.service.EmployeeService;
import com.durgasoft.service.EmployeeServiceImpl;

public class EmployeeServiceFactory {

	private static EmployeeService empService;

	static {
		empService = new EmployeeServiceImpl();
	}

	public static EmployeeService getEmployeeService() {
		return empService;
	}
}
