package com.revature.dao;

import static com.revature.util.LoggerUtil.error;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.pojo.Offer;

public class OfferDAOSerialization implements OfferDAO {

	public OfferDAOSerialization() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createOffer(Offer offer) {
		String fileName = "";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		if (offer.getOfferID() != null) {
			fileName = offer.getOfferID() + ".ofr";
		} else {
			error("null offer");
		}

		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(offer);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public Offer readOffer(String offerID) throws FileNotFoundException {

		String fileName = offerID + ".ofr";

		Offer ret = null;

		// try with resources
		try (FileInputStream fis = new FileInputStream(fileName); ObjectInputStream ois = new ObjectInputStream(fis);) {
			ret = (Offer) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return ret;
	}

	@Override
	public void deleteOffer(String OfferID) {
		File file = new File(OfferID + ".ofr");
		file.delete();
	}

}
