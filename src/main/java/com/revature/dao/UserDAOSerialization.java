package com.revature.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static com.revature.util.LoggerUtil.*;

import com.revature.pojo.User;

public class UserDAOSerialization implements UserDAO {

	@Override
	public void createUser(User u) {
		String fileName = "";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		if (u.getUsername() != null) {
			fileName = u.getUsername() + ".dat";
		} else {
			error("null username");
		}

		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(u);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public User readUser(String username) {

		String fileName = username + ".dat";

		User ret = null;

		// try with resources
		try (FileInputStream fis = new FileInputStream(fileName); ObjectInputStream ois = new ObjectInputStream(fis);) {
			ret = (User) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return ret;
	}

}
