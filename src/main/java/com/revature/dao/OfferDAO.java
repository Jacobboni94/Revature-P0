package com.revature.dao;

import java.io.FileNotFoundException;

import com.revature.pojo.Offer;

public interface OfferDAO {

	public void createOffer(Offer offer);

	public Offer readOffer(String offerID) throws FileNotFoundException;

	public void deleteOffer(String Filename);
}
