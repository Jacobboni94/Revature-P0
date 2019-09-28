package com.revature.util;

import com.revature.pojo.Car;
import com.revature.pojo.Offer;

public interface SystemInterface {
	
	double CalcMonthlyPayment(Car car);
	
	void endOtherOffers(Car car, Offer offer);

}
