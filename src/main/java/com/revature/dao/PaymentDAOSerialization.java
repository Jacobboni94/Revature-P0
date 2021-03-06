package com.revature.dao;

import static com.revature.util.LoggerUtil.error;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.pojo.Lot;
import com.revature.pojo.Payment;

public class PaymentDAOSerialization implements PaymentDAO {

	public PaymentDAOSerialization() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPayment(Payment payment) {
		String fileName = "";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		if (payment != null) {
			fileName = payment.getPaymentTime() + "-" + payment.getCar().getVin() + ".pay";
		} else {
			error("null username");
		}
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(payment);
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
	public Payment readPayment(String paymentID) {

		String fileName = paymentID + ".pay";

		Payment ret = null;

		// try with resources
		try (FileInputStream fis = new FileInputStream(fileName); ObjectInputStream ois = new ObjectInputStream(fis);) {
			ret = (Payment) ois.readObject();
		} catch (IOException e) {
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
		}
		return ret;
	}


}
