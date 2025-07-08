package com.litmus7.retaildiscountsystem.ui;

import com.litmus7.retaildiscountsystem.interfaces.*;
import com.litmus7.retaildiscountsystem.service.*;
import java.util.Scanner;

public class RetailStoreApp {
	public static void displayAmounts(double finalAmount[], double totalAmount, String type) {
		System.out.println("Customer Type: "+type);
		System.out.println("Original Amount: "+totalAmount);
		System.out.println("Discount Applied: "+finalAmount[0]);
		System.out.println("Final Payable Amount: "+finalAmount[1]);
	}
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		Discountable disc1, disc2, disc3;
		disc2 = new premiumCustomer();
		disc1 = new regularCustomer();
		disc3 = new wholesaleCustomer();
		double[] finalAmount = new double[2];
		System.out.println("Enter the Customer type: (Regular / Premium / Wholesale)\n");
		String type = sc.nextLine();
		System.out.println("Enter the total purchase Amount: \n");
		double amount = sc.nextDouble();
		switch (type) {
		case "Regular":
			finalAmount = disc1.applyDiscount(amount);
			break;
		case "Premium":
			finalAmount = disc2.applyDiscount(amount);
			break;
		case "Wholesale":
			finalAmount = disc3.applyDiscount(amount);
			break;
		}
		displayAmounts(finalAmount,amount,type);
	}

}
