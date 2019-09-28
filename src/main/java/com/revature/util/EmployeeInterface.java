package com.revature.util;

import java.util.List;

import com.revature.pojo.Car;
import com.revature.pojo.Offer;
import com.revature.pojo.Payment;

public interface EmployeeInterface extends UserInterface {

	void addToLot(Car car);

	void acceptOffer(Offer offer);

	void rejectOffer(Offer offer);

	void removeFromLot(Car car, List<Car> carLot);
	
	List<Payment> viewPayments(String userName);

}
