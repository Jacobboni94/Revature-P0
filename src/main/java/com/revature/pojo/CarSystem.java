package com.revature.pojo;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.dao.LotDAO;
import com.revature.dao.LotDAOSerialization;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOSerialization;

public class CarSystem extends Menu {

	private static UserDAO userDAO = new UserDAOSerialization();
	private Scanner in = new Scanner(System.in);
	private Lot dealerLot = new Lot();
	private LotDAO lotDAO = new LotDAOSerialization();

	public CarSystem() {
		super();
		if(dealerLot.getCars() == null) {
			dealerLot.setCars(new ArrayList<Car>());
			User dealer = new User();
			dealer.setUsername("dealerLot");
			dealerLot.setOwner(dealer);
			lotDAO.createLot(dealerLot);
		}else {
			dealerLot = lotDAO.readLot("dealerLot.lot");
		}
	}

	public User readStartInput() {
		User u = new User();
		while (true) {
			String string = in.nextLine();
			if (string.equals("1")) {
				System.out.println("login");
				u = login();
				break;
			} else if (string.equals("2")) {
				System.out.println("register");
				u = register();
				break;
			} else if (string.equals("3")) {
				System.exit(0);
			} else {
				System.out.println("please press 1 or 2");
				;
			}
		}
		return u;
	}

	private User login() {
		User u = new User();
		while (true) {
			System.out.println("please enter your username");
			String inputUsername = in.nextLine();
			u = userDAO.readUser(inputUsername);
			if (u == null) {
				System.out.println("wrong username");
			} else {
				break;
			}
		}
		while (true) {
			System.out.println("please enter your password");
			String inputPassword = in.nextLine();
			if (u.getPassword().equals(inputPassword)) {
				return u;
			} else {
				System.out.println("wrong password");
			}
		}
	}

	private User register() {
		User newUser = new User();
		String newUsername;
		while (true) {
			System.out.println("enter a user name");
			newUsername = in.nextLine();
			if (!UsernameTaken(newUsername)) {
				break;
			} else {
				System.out.println("username taken");
			}
		}
		newUser.setUsername(newUsername);
		System.out.println("enter a password");
		String newPassword = in.nextLine();
		newUser.setPassword(newPassword);
		while (true) {
			System.out.println("employee or customer");
			String newType = in.nextLine();
			if ("employee".equals(newType)) {
				newUser.setType("employee");
				break;
			} else if ("customer".equals(newType)) {
				newUser.setType("customer");
				break;
			} else {
				System.out.println("please enter employee or customer");
				System.out.println("this is case sensitive");
			}
		}
		userDAO.createUser(newUser);
		return newUser;
	}

	private boolean UsernameTaken(String username) {
		User u = userDAO.readUser(username);
		if (u != null) {
			return true;
		}
		return false;
	}

	public void readCustomerInput() {
		String string = in.nextLine();
		if (string.equals("1")) {
			// TODO view my cars
		} else if (string.equals("2")) {
			// TODO view cars on sale
		} else if (string.equals("3")) {
			System.exit(0);
		}
		else {
			System.out.println("please enter 1 through 3");
		}
	}

	public void readEmpInput() {
		String string = in.nextLine();
		if (string.equals("1")) {
			addCar();
		} else if (string.equals("2")) {
			// TODO view open offers
		} else if (string.equals("3")) {
			// TODO view cars on lot
		} else if (string.equals("4")) {
			removeCar();
		} else if (string.equals("5")) {
			//TODO view sold cars
		} else if (string.equals("6")) {
			System.exit(0);
		} else {
			System.out.println("please enter 1 through 5");
		}
	}

	private void addCar() {
		String newVin = "";
		Car newCar = new Car();
		double newPrice = 0.0;
		while (true) {
			System.out.println("enter the car's vin");
			newVin = in.nextLine();
			System.out.println("is " + newVin + " the corect vin?");
			if (in.nextLine().equals("yes")) {
				break;
			}
		}
		newCar.setVin(newVin);
		while (true) {
			System.out.println("enter the car's price");
			newPrice = in.nextDouble();
			try {
				newCar.setPrice(newPrice);
				break;
			} catch (OutOfRangeException e) {
				System.out.println("price must be greater than 0.0");
			}
		}
		dealerLot.getCars().add(newCar);
		lotDAO.createLot(dealerLot);
	}

	private void removeCar() {
		System.out.println("enter the vin");
		String vin = in.nextLine();
		
	}
	
}
