package com.litmus7.retaildiscountsystem.service;

import com.litmus7.retaildiscountsystem.interfaces.*;

public class regularCustomer implements Discountable {

	public double[] applyDiscount(double totalAmount) {
		double amounts[] = new double[2];
		double discount = totalAmount * (0.05);
		double finalAmount = totalAmount - discount;
		amounts[0] = discount;
		amounts[1] = finalAmount;
		return amounts;
	}

}
