package com.revature.dao;

import static com.revature.util.LoggerUtil.error;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.pojo.Car;

public class CarDAOSerializable implements CarDAO {

	public CarDAOSerializable() {
		super();
	}

	@Override
	public void createCar(Car c) {
		String fileName = "";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		if (c.getVin() != null) {
			fileName = c.getVin() + ".usr";
		} else {
			error("null username");
		}

		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(c);
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
	public Car readCar(String vin) {

		String fileName = vin + ".car";

		Car ret = null;

		// try with resources
		try (FileInputStream fis = new FileInputStream(fileName); ObjectInputStream ois = new ObjectInputStream(fis);) {
			ret = (Car) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return ret;
	}

}
