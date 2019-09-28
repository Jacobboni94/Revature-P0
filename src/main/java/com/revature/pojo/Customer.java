package com.revature.pojo;

import java.util.List;

import com.revature.util.CustomerInterface;

public class Customer extends User implements CustomerInterface {

	private List<Car> ownedCars;
	private double debt;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}

	public Customer(List<Car> ownedCars, double debt) {
		super();
		this.ownedCars = ownedCars;
		this.debt = debt;
	}

	public List<Car> getOwnedCars() {
		return ownedCars;
	}

	public void setOwnedCars(List<Car> ownedCars) {
		this.ownedCars = ownedCars;
	}

	public double getDebt() {
		return debt;
	}

	public void setDebt(double debt) {
		this.debt = debt;
	}

	@Override
	public String toString() {
		return "Customer [ownedCars=" + ownedCars + ", debt=" + debt + ", username=" + username + ", password="
				+ password + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(debt);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((ownedCars == null) ? 0 : ownedCars.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (Double.doubleToLongBits(debt) != Double.doubleToLongBits(other.debt))
			return false;
		if (ownedCars == null) {
			if (other.ownedCars != null)
				return false;
		} else if (!ownedCars.equals(other.ownedCars))
			return false;
		return true;
	}

	@Override
	public void viewMyCars() {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewRemainingPayments(Car car) {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewCarsOnLot(List<Car> carLot) {
		// TODO Auto-generated method stub

	}

	@Override
	public Offer makeOffer(Car car) {
		// TODO Auto-generated method stub
		return null;
	}

}
