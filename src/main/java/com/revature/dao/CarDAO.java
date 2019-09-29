package com.revature.dao;

import com.revature.pojo.Car;

public interface CarDAO {

	public void createCar(Car car);
	
	public Car readCar(String vin);
	
	public void deleteCar(String Filename);
}
