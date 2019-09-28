package com.revature.pojo;

import java.util.List;

import com.revature.util.EmployeeInterface;

public class Employee extends User implements EmployeeInterface {

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [username=" + username + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public void addToLot(Car car) {
		// TODO Auto-generated method stub

	}

	@Override
	public void acceptOffer(Offer offer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rejectOffer(Offer offer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeFromLot(Car car, List<Car> carLot) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Payment> viewPayments(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
