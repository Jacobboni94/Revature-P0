package com.revature.pojo;

import static com.revature.util.LoggerUtil.info;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

import com.revature.dao.CarDAO;
import com.revature.dao.CarDAOSerializable;
import com.revature.dao.LotDAO;
import com.revature.dao.LotDAOSerialization;
import com.revature.dao.OfferDAO;
import com.revature.dao.OfferDAOSerializable;
import com.revature.dao.PaymentDAO;
import com.revature.dao.PaymentDAOSerialization;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOSerialization;
import com.revature.exception.OutOfRangeException;

public class CarSystem extends Menu {

	private static UserDAO userDAO = new UserDAOSerialization();
	private static LotDAO lotDAO = new LotDAOSerialization();
	private static CarDAO carDAO = new CarDAOSerializable();
	private static OfferDAO offerDAO = new OfferDAOSerializable();
	private static PaymentDAO paymentDAO = new PaymentDAOSerialization();
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
			makePayment(u);
		} else if (string.equals("6")) {
			in.close();
			System.exit(0);
		} else {
			System.out.println("please enter 1 through 3");
		}
	}

	public void readEmpInput() {
		String string = in.nextLine();
		if (string.equals("1")) {
			addNewCar(dealerLot);
		} else if (string.equals("2")) {
			acceptOffer();
		} else if (string.equals("3")) {
			rejectOffer();
		} else if (string.equals("4")) {
			viewCarsOnSale();
		} else if (string.equals("5")) {
			removeCar(dealerLot);
		} else if (string.equals("6")) {
			viewPayments();
		} else if (string.equals("7")) {
			in.close();
			System.exit(0);
		} else {
			System.out.println("please enter 1 through 7");
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
				if (existingOffer(u, car)) {
					System.out.println("you've already make an offer for this car");
				} else {
					break;
				}
			} catch (FileNotFoundException e) {
				info("file not found");
				System.out.println("car not found");
			}
		}
		newOffer.setCar(car);
		newOffer.setOfferID(vin + "-" + u.getUsername());
		System.out.println("this car costs " + car.getPrice());
		System.out.println("enter your offer amount");
		double newAmount = in.nextDouble();
		newOffer.setAmount(newAmount);
		offerDAO.createOffer(newOffer);
	}

	private boolean existingOffer(User user, Car car) {
		String string = "D:\\Revature\\repos\\Revature-P0\\" + user.getUsername() + "-" + car.getVin() + ".ofr";
		Path filename = Paths.get(string);
		return !Files.notExists(filename, LinkOption.NOFOLLOW_LINKS);
	}

	public void viewRemainingPayments() {
		// TODO Auto-generated method stub
		System.out.println("which car?");
		String vin = in.nextLine();

	}

	public void makePayment(User u) {
		Car car;
		double amount;
		System.out.println("which car are you paying for?");
		System.out.println("enter the vin");
		String vin = in.nextLine();
		try {
			car = carDAO.readCar(vin);
		} catch (FileNotFoundException e) {
			System.out.println("wrong vin");
			e.printStackTrace();
			return;
		}
		System.out.println("how much will you pay");
		amount = in.nextDouble();
		Payment newPayment = new Payment();
		newPayment.setAmount(amount);
		newPayment.setCar(car);
		newPayment.setPaymentTime(LocalDate.now());
		newPayment.setRemainingAmount(car.getPrice() - amount);
		paymentDAO.createPayment(newPayment);
		// TODO
	}

	public void viewMyCars(User u) {
		String name = u.getUsername();
		Lot myLot = lotDAO.readLot(name);
		System.out.println(myLot.getCars().toString());
	}

	public void viewCarsOnSale() {
		System.out.println(dealerLot.getCars().toString());
	}

	public void acceptOffer() {
		String offerID;
		while (true) {
			System.out.println("Which offer would you like to accept");
			offerID = in.nextLine();
			try {
				Offer offer = offerDAO.readOffer(offerID);
				Car soldCar = offer.getCar();
				soldCar.setPrice(offer.getAmount());
				User newOwner = offer.getUser();
				addToUserLot(newOwner, soldCar);
				deleteOtherOffers(offer);
			} catch (FileNotFoundException e) {
				break;
			} catch (OutOfRangeException e) {
				info("out of range exception");
			}
		}
	}

	private void addToUserLot(User newOwner, Car soldCar) {
		String string = "D:\\Revature\\repos\\Revature-P0\\" + newOwner.getUsername() + ".lot";
		Path filename = Paths.get(string);
		Lot lot;
		if (Files.notExists(filename, LinkOption.NOFOLLOW_LINKS)) {
			lot = new Lot(newOwner);
			lot.getCars().add(soldCar);
		} else {
			lot = lotDAO.readLot(newOwner.getUsername() + ".lot");
			lot.getCars().add(soldCar);
		}
		lotDAO.createLot(lot);
	}

	private void deleteOtherOffers(Offer offer) {
		File file = new File("D:\\Revature\\repos\\Revature-P0\\");
		File[] files = file.listFiles();
		Stream<File> fileStream = Arrays.stream(files);
		fileStream.filter(f -> f.getName().contains(".ofr")).forEach(f -> {
			f.delete();
		});
	}

	public void rejectOffer() {
		String offerID;
		while (true) {
			System.out.println("Which offer would you like to reject");
			offerID = in.nextLine();
			try {
				offerDAO.readOffer(offerID);
				offerDAO.deleteOffer(offerID);
			} catch (FileNotFoundException e) {
				break;
			}
		}
	}

	public void viewPayments() {
		File file = new File("D:\\Revature\\repos\\Revature-P0\\");
		File[] files = file.listFiles();
		Stream<File> fileStream = Arrays.stream(files);
		fileStream.filter(f -> f.getName().contains(".pay")).forEach(f -> {
			System.out.println(f.getName());
			System.out.println(paymentDAO.readPayment(f.getName().substring(0, f.getName().length()-4)).getAmount());
		});
	}

	public void addNewCar(Lot lot) {
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
