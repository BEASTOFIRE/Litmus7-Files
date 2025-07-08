package com.litmus7.retaildiscountsystem.service;

import com.litmus7.retaildiscountsystem.interfaces.Discountable;

public class wholesaleCustomer implements Discountable {

	public double[] applyDiscount(double totalAmount) {
		double amounts[]=new double[2];
		if (totalAmount >= 10000) {
			double discount=totalAmount * (0.15);
			double finalAmount = totalAmount - discount;
			amounts[0]=discount;
			amounts[1]=finalAmount;
			return amounts;
			
		} else {
			double discount=totalAmount * (0.1);
			double finalAmount = totalAmount - discount;
			amounts[0]=discount;
			amounts[1]=finalAmount;
			return amounts;
		}
	}

}
