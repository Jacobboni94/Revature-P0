package com.revature.pojo;

public class Menu {

	public void printStartMenu() {
		System.out.println("1: login");
		System.out.println("2: register");
		System.out.println("3: exit");

	}

	public void printCustMenu() {
		System.out.println("1: view my cars");
		System.out.println("2: view cars for sale");
		System.out.println("3: exit");
	}

	public void printEmpMenu() {
		System.out.println("1: add car to lot");
		System.out.println("2: view open offers");
		System.out.println("3: view cars on lot");
		System.out.println("4: remove car from lot");
		System.out.println("5: view sold cars");
		System.out.println("6: exit");
	}
}
