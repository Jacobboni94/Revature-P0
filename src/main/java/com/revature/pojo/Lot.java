package com.revature.pojo;

import java.io.Serializable;
import java.util.List;

public class Lot implements Serializable{ 

	private List<Car> cars;
	private User owner;
	
	public Lot() {
		super();
	}
	
	public Lot(User user) {
		this.owner = user;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
	
}
