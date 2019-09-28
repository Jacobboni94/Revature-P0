package com.revature.pojo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import com.revature.util.SystemInterface;

public class CarSystem implements SystemInterface {

	private List<Car> carLot;

	public CarSystem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarSystem(List<Car> carLot) {
		super();
		this.carLot = carLot;
	}

	public List<Car> getCarLot() {
		return carLot;
	}

	public void setCarLot(List<Car> carLot) {
		this.carLot = carLot;
	}

	@Override
	public String toString() {
		return "System [carLot=" + carLot + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carLot == null) ? 0 : carLot.hashCode());
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
		CarSystem other = (CarSystem) obj;
		if (carLot == null) {
			if (other.carLot != null)
				return false;
		} else if (!carLot.equals(other.carLot))
			return false;
		return true;
	}

	@Override
	public double CalcMonthlyPayment(Car car) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void endOtherOffers(Car car, Offer offer) {
		// TODO Auto-generated method stub

	}
}
