package com.revature.main;

import com.revature.pojo.CarSystem;

public class Driver {

	public static void main(String[] args) {
		CarSystem dealership = new CarSystem();
		dealership.printMenu();
		dealership.readStartInput();
	}

}
