package com.revature.pojo;

import java.io.Serializable;

public class Car implements Serializable {

	private String vin;
	private double price;
	private Lot lot;

	public Car() {
		super();
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Lot getLot() {
		return lot;
	}

	public void setLot(Lot lot) {
		this.lot = lot;
	}

}
