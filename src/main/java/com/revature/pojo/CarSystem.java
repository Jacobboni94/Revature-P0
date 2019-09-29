package com.revature.pojo;

import static com.revature.util.LoggerUtil.warn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOSerialization;

public class CarSystem extends Menu {

	private List<User> currentUsers = new ArrayList<User>();
	public static UserDAO userDAO = new UserDAOSerialization();
	private Scanner in = new Scanner(System.in);

	public CarSystem() {
		super();
	}

	public void readStartInput() {
		while (true) {
			String string = in.nextLine();
			if (string.equals("1")) {
				System.out.println("login");
				login();
				break;
			} else if (string.equals("2")) {
				System.out.println("register");
				register();
				break;
			} else {
				warn("i/o error");
			}
		}
	}

	private void login() {
	}

	private void register() {
		User newUser = new Customer();
		String newUsername;
		while (true) {
			System.out.println("enter a user name");
			newUsername = in.nextLine();
			if (!UsernameTaken(newUsername)) {
				break;
			} else {
				System.out.println("username taken");
				newUsername = in.nextLine();
			}
		}
		newUser.setUsername(newUsername);
		System.out.println("enter a password");
		String newPassword = in.nextLine();
		newUser.setPassword(newPassword);
		in.close();
		currentUsers.add(newUser);
		userDAO.createUser(newUser);
	}

	private boolean UsernameTaken(String username) {
		// TODO Auto-generated method stub
		for (User u : currentUsers) {
			if (u.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}
}
