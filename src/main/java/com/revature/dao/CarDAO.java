package com.revature.dao;

import java.io.FileNotFoundException;

import com.revature.pojo.Car;

public interface CarDAO {

	public void createCar(Car car);
	
	public Car readCar(String vin) throws FileNotFoundException;
	
	public void deleteCar(String Filename);
}
