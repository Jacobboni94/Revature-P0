package com.revature.pojo;

import java.util.Scanner;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOSerialization;

public class CarSystem extends Menu {

	public static UserDAO userDAO = new UserDAOSerialization();
	private Scanner in = new Scanner(System.in);

	public CarSystem() {
		super();
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
			}
			else if(string.equals("3")) {
				System.exit(0);
			}
			else {
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
			}
			else {
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
		while(true) {
			System.out.println("employee or customer");
			String newType = in.nextLine();
			if("employee".equals(newType)) {
				newUser.setType("employee");
				break;
			}
			else if("customer".equals(newType)) {
				newUser.setType("customer");
				break;
			}
			else {
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
		if(string.equals("1")) {
			//view my cars
		}
		else if(string.equals("2")) {
			//view cars on sale
		}
		else if(string.equals("3")){
			System.exit(0);
		}
		
	}

	public void readEmpInput() {
		String string = in.nextLine();
		if(string.equals("1")) {
			//add car to lot
		}
		
		else if(string.equals("2")) {
			//view open offers
		}
		else if(string.equals("5")) {
			//view cars on lot
		}
		else if(string.equals("3")) {
			
		}
		else if(string.equals("4")) {
			//view sold cars
		}
		else if(string.equals("5")) {
			System.exit(0);
		}
		else {
			System.out.println("please enter 1 through 5");
		}
		
	}
}
