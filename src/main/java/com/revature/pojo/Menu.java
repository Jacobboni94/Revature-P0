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
		System.out.println("3: view remaining payments for a car");
		System.out.println("4: make an offer for a car");
		System.out.println("5: make a payment");
		System.out.println("6: exit");
	}

	public void printEmpMenu() {
		System.out.println("1: add car to lot");
		System.out.println("2: accept an offer");
		System.out.println("3: reject an offer");
		System.out.println("4: view cars on sale");
		System.out.println("4: remove car from lot");
		System.out.println("5: view payments");
		System.out.println("6: exit");
	}
}
