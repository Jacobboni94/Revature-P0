package com.revature.pojo;

import java.util.List;

import com.revature.util.SystemInterface;

public class System implements SystemInterface{

	List<Car> carLot;

	public System() {
		super();
		// TODO Auto-generated constructor stub
	}

	public System(List<Car> carLot) {
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
		System other = (System) obj;
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
