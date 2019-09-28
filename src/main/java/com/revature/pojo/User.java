package com.revature.pojo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

import com.revature.util.UserInterface;

public class User implements UserInterface {

	String username;
	String password;

	public User login() {
		System.out.println("Please enter username: ");
		Reader reader = null;
		Scanner in = new Scanner(System.in);
		String inputUsername = in.next();
		
		in.close();
		return null;
	}

	public void register() {
		// TODO Auto-generated method stub

	}

	private static boolean isInFile(String inputUsername, Reader reader) {
		String EmployeeUsernames = "D:\\Revature\\repos\\Revature-P0\\src\\main\\resources\\Employee_Usernames.dat";
		String EmployeePasswords = "D:\\Revature\\repos\\Revature-P0\\src\\main\\resources\\Employee_Passwords.dat";
		String CustomerUsernames = "D:\\Revature\\repos\\Revature-P0\\src\\main\\resources\\Customer_Usernames.dat";
		String CustomerPasswords = "D:\\Revature\\repos\\Revature-P0\\src\\main\\resources\\Customer_Passwords.dat";
		String username = "";
		try {
			reader = new FileReader(EmployeeUsernames);
			int data = reader.read();
			while (data > 0 ) {
				username += (char) data;
				if(username.equals(inputUsername)) {
					System.out.println("please enter password: ");
				}
				data = reader.read();
			}
		} catch (FileNotFoundException e1) {
			// TODO file not found error message
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO io error message
			e.printStackTrace();
		}
		
		return false;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
