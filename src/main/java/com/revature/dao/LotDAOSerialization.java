package com.revature.dao;

import static com.revature.util.LoggerUtil.error;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.pojo.Lot;

public class LotDAOSerialization implements LotDAO {

	public LotDAOSerialization() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createLot(Lot lot) {
		String fileName = "";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		if (lot.getOwner() != null) {
			fileName = lot.getOwner().getUsername() + ".lot";
		} else {
			error("null username");
		}
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(lot);
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
	public Lot readLot(String owner) {

		String fileName = owner + ".lot";

		Lot ret = null;

		// try with resources
		try (FileInputStream fis = new FileInputStream(fileName); ObjectInputStream ois = new ObjectInputStream(fis);) {
			ret = (Lot) ois.readObject();
		} catch (IOException e) {
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
		}
		return ret;
	}

	@Override
	public void updateLot(Lot lot) {
	}

}
