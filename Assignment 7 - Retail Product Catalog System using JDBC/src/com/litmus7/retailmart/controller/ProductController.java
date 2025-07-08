package com.litmus7.retailmart.controller;

import com.litmus7.retailmart.dto.*;
import com.litmus7.retailmart.dao.*;
import java.util.List;

/**
 * Controller class for handling all product-related operations.
 */
public class ProductController {

	/** Status code indicating a successful operation. */
	public static final int SUCCESS_STATUS_CODE = 200;

	/** Status code indicating an error or failure. */
	public static final int ERROR_STATUS_CODE = 400;

	/** DAO instance used to perform database operations for Product. */
	ProductDAOImpl productDAO = new ProductDAOImpl();

	/** A Product instance for temporary usage or updates. */
	public Product product = new Product();

	/**
	 * Constructor that receives a DAO and Product object from the UI.
	 *
	 * @param productDAO DAO implementation to be used.
	 * @param product    Initial product object.
	 */
	public ProductController(ProductDAOImpl productDAO, Product product) {
		this.product = product;
		this.productDAO = productDAO;
	}

	/**
	 * Validates and adds a new product to the database.
	 *
	 * @param product The product to be added.
	 * @return A Response indicating success or failure.
	 */
	public Response<String> validateAddProduct(Product product) {
		try {
			productDAO.addProduct(product);
			return new Response<String>("Product Inputted Successfully", SUCCESS_STATUS_CODE, true);
		} catch (Exception e) {
			return new Response<String>(e.getMessage(), ERROR_STATUS_CODE, false);
		}
	}

	/**
	 * Retrieves a product by its ID.
	 *
	 * @param productId The ID of the product to fetch.
	 * @return A Response containing the product or an error message.
	 */
	public Response<Product> validateGetProduct(int productId) {
		try {
			product = productDAO.getProductById(productId);
			return new Response<Product>("Product Returned Successfully", SUCCESS_STATUS_CODE, true, product);
		} catch (Exception e) {
			return new Response<Product>(e.getMessage(), ERROR_STATUS_CODE, false, null);
		}
	}

	/**
	 * Fetches all products from the database.
	 *
	 * @return A Response with a list of all products.
	 */
	public Response<List<Product>> validateGetAllProducts() {
		try {
			List<Product> products = productDAO.getAllProducts();
			return new Response<List<Product>>("Product Returned Successfully", SUCCESS_STATUS_CODE, true, products);
		} catch (Exception e) {
			return new Response<List<Product>>(e.getMessage(), ERROR_STATUS_CODE, false, null);
		}
	}

	/**
	 * Validates and updates an existing product in the database.
	 *
	 * @param product The product object with updated values.
	 * @return A Response indicating success or failure.
	 */
	public Response<String> validateUpdateProduct(Product product) {
		try {
			productDAO.updateProduct(product);
			return new Response<String>("Product Updated Successfully", SUCCESS_STATUS_CODE, true);
		} catch (Exception e) {
			return new Response<String>(e.getMessage(), ERROR_STATUS_CODE, false, null);
		}
	}

	/**
	 * Deletes a product from the database by ID.
	 *
	 * @param productId The ID of the product to be deleted.
	 * @return A Response indicating success or failure.
	 */
	public Response<String> validateDeleteProduct(int productId) {
		try {
			productDAO.deleteProduct(productId);
			return new Response<String>("Product Deleted Successfully", SUCCESS_STATUS_CODE, true);
		} catch (Exception e) {
			return new Response<String>(e.getMessage(), ERROR_STATUS_CODE, false, null);
		}
	}
}
