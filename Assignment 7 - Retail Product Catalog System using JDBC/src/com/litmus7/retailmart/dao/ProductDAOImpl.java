package com.litmus7.retailmart.dao;

import java.util.List;
import java.util.ArrayList;

import com.litmus7.retailmart.dto.Product;   // Product DTO
import com.litmus7.retailmart.exceptions.*;
import com.litmus7.retailmart.jdbcutil.DBUtil; // DB connection utility
import java.sql.*; // JDBC classes

/**
 * DAO Implementation class for Product operations.
 * Handles database access logic for CRUD operations.
 */
public class ProductDAOImpl implements ProductDAOInterface {

	/**
	 * Adds a new product to the database after checking for uniqueness by productId.
	 */
	public void addProduct(Product product) throws ProductDAOException {
		String insQuery = "INSERT INTO products (productId,name,category,price,stockQuantity) values(?,?,?,?,?)";
		String checkQuery = "SELECT productId from products where productId= ? ";

		try (
			Connection myCon = DBUtil.getConnection();
			PreparedStatement checkStmt = myCon.prepareStatement(checkQuery)
		) {
			checkStmt.setInt(1, product.getProductID());
			ResultSet rs = checkStmt.executeQuery();

			// If product already exists, throw exception
			if (rs.next()) {
				throw new ProductDAOException("Same ProductID exists.\n");
			}

			// Insert new product
			try (PreparedStatement insStmt = myCon.prepareStatement(insQuery)) {
				insStmt.setInt(1, product.getProductID());
				insStmt.setString(2, product.getName());
				insStmt.setString(3, product.getCategory());
				insStmt.setDouble(4, product.getPrice());
				insStmt.setInt(5, product.getStockQuantity());

				int rowsOutput = insStmt.executeUpdate();
				if (rowsOutput == 0) {
					throw new ProductDAOException("Could not Add new Product.\n");
				}
			} catch (SQLException e) {
				throw new ProductDAOException("Could not execute prepared Statement for Insert. " + e.getLocalizedMessage());
			}
		} catch (SQLException e) {
			throw new ProductDAOException("Could not Connect to DB. " + e.getLocalizedMessage());
		}
	}

	/**
	 * Retrieves a single product from the database by its ID.
	 */
	public Product getProductById(int productId) throws ProductDAOException {
		String checkQuery = "SELECT productId,name,category,price,stockQuantity from products where productId= ? ";

		try (
			Connection myCon = DBUtil.getConnection();
			PreparedStatement checkStmt = myCon.prepareStatement(checkQuery)
		) {
			checkStmt.setInt(1, productId);
			ResultSet rs = checkStmt.executeQuery();

			if (rs.next()) {
				// Extracting product details from ResultSet
				int productID = rs.getInt("productId");
				String name = rs.getString("name");
				String category = rs.getString("category");
				double price = rs.getDouble("price");
				int stockQuantity = rs.getInt("stockQuantity");

				// Creating Product object and returning it
				Product product = new Product(productID, name, category, price, stockQuantity);
				return product;
			} else {
				throw new ProductDAOException("Product with " + productId + " does not exist.\n");
			}
		} catch (SQLException e) {
			throw new ProductDAOException("Could not Connect to DB or PreparedStatement error. " + e.getLocalizedMessage());
		}
	}

	/**
	 * Retrieves all products from the products table.
	 */
	public List<Product> getAllProducts() throws ProductDAOException {
		List<Product> products = new ArrayList<>();
		String showQuery = "SELECT * FROM products";

		try (
			Connection myCon = DBUtil.getConnection();
			Statement myStmt = myCon.createStatement()
		) {
			ResultSet rs = myStmt.executeQuery(showQuery);

			while (rs.next()) {
				// Fetch each product and add to list
				int productID = rs.getInt("productId");
				String name = rs.getString("name");
				String category = rs.getString("category");
				double price = rs.getDouble("price");
				int stockQuantity = rs.getInt("stockQuantity");
				Product product = new Product(productID, name, category, price, stockQuantity);
				products.add(product);
			}

			// If no products found, throw exception
			if (products.isEmpty()) {
				throw new ProductDAOException("Table is Empty.\n");
			}

			return products;
		} catch (SQLException e) {
			throw new ProductDAOException("Could not connect to DB or Statement Error. " + e.getLocalizedMessage());
		}
	}

	/**
	 * Updates an existing product in the database.
	 */
	public void updateProduct(Product product) throws ProductDAOException {
		String updateQuery = "UPDATE products SET name = ?, category = ?, price = ?, stockQuantity = ? WHERE productId = ?";
		String checkQuery = "SELECT productId FROM products WHERE productId = ?";

		int productId = product.getProductID();

		try (
			Connection myCon = DBUtil.getConnection();
			PreparedStatement checkStmt = myCon.prepareStatement(checkQuery)
		) {
			checkStmt.setInt(1, productId);
			ResultSet rs = checkStmt.executeQuery();

			// Check if product exists before updating
			if (rs.next()) {
				try (PreparedStatement updateStmt = myCon.prepareStatement(updateQuery)) {
					// Set new values for update
					updateStmt.setString(1, product.getName());
					updateStmt.setString(2, product.getCategory());
					updateStmt.setDouble(3, product.getPrice());
					updateStmt.setInt(4, product.getStockQuantity());
					updateStmt.setInt(5, productId);

					int rowsUpdated = updateStmt.executeUpdate();
					if (rowsUpdated == 0) {
						throw new ProductDAOException("Failed to update Product.");
					}
				} catch (SQLException e) {
					throw new ProductDAOException("Prepared update Statement error. " + e.getLocalizedMessage());
				}
			} else {
				throw new ProductDAOException("No Such Product Exists.\n");
			}
		} catch (SQLException e) {
			throw new ProductDAOException("Could not Connect to DB or prepared Statement Error.\n" + e.getLocalizedMessage());
		}
	}

	/**
	 * Deletes a product from the database by its ID.
	 */
	public void deleteProduct(int productId) throws ProductDAOException {
		String checkQuery = "SELECT productId FROM products WHERE productId = ?";
		String deleteQuery = "DELETE FROM products WHERE productId = ?";

		try (
			Connection myCon = DBUtil.getConnection();
			PreparedStatement checkStmt = myCon.prepareStatement(checkQuery)
		) {
			checkStmt.setInt(1, productId);
			ResultSet rs = checkStmt.executeQuery();

			// Check if product exists before deleting
			if (rs.next()) {
				try (PreparedStatement deleteStmt = myCon.prepareStatement(deleteQuery)) {
					deleteStmt.setInt(1, productId);
					int rowsUpdated = deleteStmt.executeUpdate();

					if (rowsUpdated == 0) {
						throw new ProductDAOException("Failed to delete Product.");
					}
				} catch (SQLException e) {
					throw new ProductDAOException("Prepared Delete Statement Error.\n" + e.getLocalizedMessage());
				}
			} else {
				throw new ProductDAOException("Record with productId " + productId + " does not exist.\n");
			}
		} catch (SQLException e) {
			throw new ProductDAOException("Could not Connect to DB or Prepared Check Statement Error. " + e.getLocalizedMessage());
		}
	}
}
