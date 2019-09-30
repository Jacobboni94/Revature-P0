package com.revature.pojo;

import java.io.Serializable;

import com.revature.exception.OutOfRangeException;

public class Car implements Serializable {

	private String vin;
	private double price;
	private double remainingPrice;
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

	public void setPrice(double price) throws OutOfRangeException {
		if(price < 0) {
			throw new OutOfRangeException();
		}
		this.price = price;
	}

	public Lot getLot() {
		return lot;
	}

	public void setLot(Lot lot) {
		this.lot = lot;
	}

	public double getRemainingPrice() {
		return remainingPrice;
	}

	public void setRemainingPrice(double remainingPrice) {
		this.remainingPrice = remainingPrice;
	}

	@Override
	public String toString() {
		return "Car [vin=" + vin + ", price=" + price + ", lot=" + lot + "]";
	}

}
