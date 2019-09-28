package com.revature.util;

import java.util.List;

import com.revature.pojo.Car;
import com.revature.pojo.Offer;

public interface CustomerInterface {

	void viewMyCars();

	void viewRemainingPayments(Car car);
	
	void viewCarsOnLot(List<Car> carLot);
	
	Offer makeOffer(Car car);
}
