package com.revature.pojo;

import java.io.Serializable;
import java.time.LocalDate;

public class Payment implements Serializable{
	
	private double amount = 0.0;
	private double remainingAmount = 0.0;
	private Car car; //for which car is the payment
	private LocalDate paymentTime;

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

	public LocalDate getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(LocalDate paymentTime) {
		this.paymentTime = paymentTime;
	}

}
