package com.litmus7.retailmart.dao;

import com.litmus7.retailmart.dto.*; // Importing Product DTO
import java.util.List;
import com.litmus7.retailmart.exceptions.*; // Custom DAO exception class

/**
 * Interface that defines the DAO operations for managing Product entities.
 * This allows different implementations (e.g., JDBC, JPA) to adhere to a consistent contract.
 */
public interface ProductDAOInterface {

    /**
     * Adds a new product to the database.
     * @param product The product object containing all details.
     * @throws ProductDAOException if the product cannot be added or already exists.
     */
    void addProduct(Product product) throws ProductDAOException;

    /**
     * Retrieves a product from the database based on its ID.
     * @param productId ID of the product to retrieve.
     * @return Product object with all details.
     * @throws ProductDAOException if the product is not found or retrieval fails.
     */
    Product getProductById(int productId) throws ProductDAOException;

    /**
     * Retrieves a list of all products in the database.
     * @return List of Product objects.
     * @throws ProductDAOException if the table is empty or query fails.
     */
    List<Product> getAllProducts() throws ProductDAOException;

    /**
     * Updates an existing product in the database.
     * @param product The updated product object.
     * @throws ProductDAOException if the product does not exist or update fails.
     */
    void updateProduct(Product product) throws ProductDAOException;

    /**
     * Deletes a product from the database by its ID.
     * @param productId ID of the product to delete.
     * @throws ProductDAOException if the product does not exist or deletion fails.
     */
    void deleteProduct(int productId) throws ProductDAOException;
}
