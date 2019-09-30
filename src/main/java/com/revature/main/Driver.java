package com.revature.main;

import com.revature.pojo.CarSystem;
import com.revature.pojo.User;

public class Driver {

	public static void main(String[] args) {
		CarSystem dealership = new CarSystem();
		dealership.systemStart();
		dealership.printStartMenu();
		User u = dealership.readStartInput();
		if ("customer".equals(u.getType())) {
			while (true) {
				dealership.printCustMenu();
				dealership.readCustomerInput(u);
			}
		} else {
			while (true) {
				dealership.printEmpMenu();
				dealership.readEmpInput();
			}
		}
	}
}
