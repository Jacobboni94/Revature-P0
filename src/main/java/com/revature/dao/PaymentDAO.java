package com.revature.dao;

import com.revature.pojo.Payment;

public interface PaymentDAO {

	public void createPayment(Payment Payment);

	public Payment readPayment(String paymentID);

}
