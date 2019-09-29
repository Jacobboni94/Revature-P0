package com.revature.main;

import com.revature.pojo.CarSystem;
import com.revature.pojo.User;

public class Driver {

	public static void main(String[] args) {
		CarSystem dealership = new CarSystem();
		dealership.printStartMenu();
		User u = dealership.readStartInput();
		if ("customer".equals(u.getType())) {
			dealership.printCustMenu();
			dealership.readCustomerInput();
		} else {
			dealership.printEmpMenu();
			dealership.readEmpInput();
		}
	}
}
