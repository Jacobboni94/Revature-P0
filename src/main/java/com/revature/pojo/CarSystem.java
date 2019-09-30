package com.revature.pojo;

import static com.revature.util.LoggerUtil.info;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.dao.CarDAO;
import com.revature.dao.CarDAOSerializable;
import com.revature.dao.LotDAO;
import com.revature.dao.LotDAOSerialization;
import com.revature.dao.OfferDAO;
import com.revature.dao.OfferDAOSerializable;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOSerialization;
import com.revature.exception.OutOfRangeException;

public class CarSystem extends Menu {

	private static UserDAO userDAO = new UserDAOSerialization();
	private static LotDAO lotDAO = new LotDAOSerialization();
	private static CarDAO carDAO = new CarDAOSerializable();
	private static OfferDAO offerDAO = new OfferDAOSerializable();
	private Scanner in = new Scanner(System.in);
	private Lot dealerLot;

	public CarSystem() {
		super();
	}

	public void systemStart() {
		dealerLot = lotDAO.readLot("dealerLot");
		if (dealerLot == null) {
			User dealer = new User("dealerLot", "admin", "employee");
			dealerLot = new Lot(dealer);
			dealerLot.setCars(new ArrayList<Car>());
			lotDAO.createLot(dealerLot);
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

	public User login() {
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

	public User register() {
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
				Lot newLot = new Lot(newUser);
				lotDAO.createLot(newLot);
				break;
			} else {
				System.out.println("please enter employee or customer");
				System.out.println("this is case sensitive");
			}
		}
		userDAO.createUser(newUser);
		return newUser;
	}

	public boolean UsernameTaken(String username) {
		User u = userDAO.readUser(username);
		if (u != null) {
			return true;
		}
		return false;
	}

	public void readCustomerInput(User u) {
		String string = in.nextLine();
		if (string.equals("1")) {
			viewMyCars(u);
		} else if (string.equals("2")) {
			viewCarsOnSale();
		} else if (string.equals("3")) {
			viewRemainingPayments();
		} else if (string.equals("4")) {
			makeOffer(u);
		} else if (string.equals("5")) {
			System.exit(0);
		} else {
			System.out.println("please enter 1 through 3");
		}
	}

	public void readEmpInput() {
		String string = in.nextLine();
		if (string.equals("1")) {
			addCar(dealerLot);
		} else if (string.equals("2")) {
			viewOpenOffers();
		} else if (string.equals("3")) {
			viewCarsOnSale();
		} else if (string.equals("4")) {
			removeCar(dealerLot);
		} else if (string.equals("5")) {
			viewPayments();
		} else if (string.equals("6")) {
			System.exit(0);
		} else {
			System.out.println("please enter 1 through 5");
		}
	}

	public void makeOffer(User u) {
		Offer newOffer = new Offer();
		String vin = "";
		Car car = new Car();
		while (true) {
			System.out.println("which car is the offer for?");
			System.out.println("enter vin");
			vin = in.nextLine();
			try {
				car = carDAO.readCar(vin);
				if(existingOffer(u, car)) {
					System.out.println("you've already make an offer for this car");
				}
				else {
					break;
				}
			} catch (FileNotFoundException e) {
				info("file not found");
				System.out.println("car not found");
			}
		}
		newOffer.setCar(car);
		newOffer.setOfferID(vin + "|" + u.getUsername());
		System.out.println("this car costs " + car.getPrice());
		System.out.println("enter your offer amount");
		double newAmount = in.nextDouble();
		newOffer.setAmount(newAmount);
	}

	private boolean existingOffer(User user, Car car) {
		try {
			Offer existingOffer = offerDAO.readOffer(car.getVin() + "|" + user.getUsername());
			return true;
		}catch(FileNotFoundException e) {
			return false;
		}
	}

	public void viewRemainingPayments() {
		// TODO Auto-generated method stub

	}

	public void viewMyCars(User u) {
		String name = u.getUsername();
		Lot myLot = lotDAO.readLot(name);
		System.out.println(myLot.getCars().toString());
	}

	public void viewCarsOnSale() {
		System.out.println(dealerLot.getCars().toString());
	}

	public void viewOpenOffers() {
		// TODO Auto-generated method stub

	}

	public void viewPayments() {
		// TODO Auto-generated method stub

	}

	public void addCar(Lot lot) {
		String newVin = "";
		Car newCar = new Car();
		newCar.setLot(lot.getOwner().getUsername());
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
		carDAO.createCar(newCar);
		lot.getCars().add(newCar);
		lotDAO.createLot(lot);
	}

	public void removeCar(Lot lot) {
		while (true) {
			System.out.println("enter the vin");
			String vin = in.nextLine();
			Car car = new Car();
			try {
				car = carDAO.readCar(vin);
				break;
			} catch (FileNotFoundException e) {
				System.out.println("there is no car with vin " + vin);
				e.printStackTrace();
			}
			lot.getCars().remove(car);
			carDAO.deleteCar(vin);
			lotDAO.createLot(lot);
		}
	}

}
