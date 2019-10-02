package com.revature.pojo;

public class Payment {
	
	private double amount = 0.0;
	private double remainingAmount = 0.0;
	private Car car; //for which car is the payment

	public Payment() {
		super();
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public double getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(double remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
