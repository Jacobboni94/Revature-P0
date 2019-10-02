package com.revature.pojo;

import java.io.Serializable;

public class Offer implements Serializable{
	
	private Car car;
	private User user;
	private double amount;
	private String OfferID;

	public Offer() {
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getOfferID() {
		return OfferID;
	}

	public void setOfferID(String offerID) {
		OfferID = offerID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
}
