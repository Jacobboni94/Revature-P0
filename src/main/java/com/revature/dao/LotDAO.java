package com.revature.dao;

import com.revature.pojo.Lot;

public interface LotDAO {

	public void createLot(Lot lot);
	
	public Lot readLot(String owner);
	
	public void updateLot(Lot lot);

}
