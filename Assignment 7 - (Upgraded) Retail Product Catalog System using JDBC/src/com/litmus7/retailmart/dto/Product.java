package com.litmus7.retailmart.dto;

/**
 * DTO class representing a Product in the RetailMart system.
 */
public class Product {
	private int productID;
	private String name;
	private String category;
	private double price; 
	private int stockQuantity;

	// Default constructor (used when a blank product object is needed)
	public Product(){
	}
	
	// Parameterized constructor to initialize product details
	public Product(int productID, String name, String category, double price, int stockQuantity) {
		this.productID = productID;
		this.name = name;
		this.category = category;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	// Override toString() for easy printing/debugging of product details
	@Override
	public String toString() {
		return "Product [productID=" + productID + ", name=" + name + ", category=" + category + ", price=" + price
				+ ", stockQuantity=" + stockQuantity + "]";
	}

	// Getter and Setter methods

	/**
	 * @return the productID
	 */
	public int getProductID() {
		return productID;
	}

	/**
	 * @param productID the productID to set
	 */
	public void setProductID(int productID) {
		this.productID = productID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the stockQuantity
	 */
	public int getStockQuantity() {
		return stockQuantity;
	}

	/**
	 * @param stockQuantity the stockQuantity to set
	 */
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
}
