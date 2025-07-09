package com.litmus7.retailmart.service;

import com.litmus7.retailmart.dao.ProductDAOInterface;
import com.litmus7.retailmart.dto.Product;
import com.litmus7.retailmart.exceptions.ProductDAOException;
import com.litmus7.retailmart.exceptions.ProductServiceException;

import java.util.List;

/**
 * Service class that contains business logic for product operations.
 */
public class ProductService {

    /**
     * DAO interface used to interact with the product data.
     */
    private ProductDAOInterface productDAO;

    /**
     * Constructor to initialize the ProductService with a DAO implementation.
     *
     * @param productDAO the data access object implementation
     */
    public ProductService(ProductDAOInterface productDAO) {
        this.productDAO = productDAO;
    }

    /**
     * Adds a product after performing necessary validations.
     *
     * @param product the product to be added
     * @throws ProductServiceException if validations fail or DAO throws an exception
     */
    public void addProduct(Product product) throws ProductServiceException {
        try {
            if (product.getProductID() <= 0) {
                throw new ProductServiceException("Product ID must be positive.");
            }
            if (product.getName() == null || product.getName().trim().isEmpty()) {
                throw new ProductServiceException("Product name cannot be empty.");
            }
            if (product.getPrice() <= 0) {
                throw new ProductServiceException("Product price must be greater than 0.");
            }
            if (product.getStockQuantity() < 0) {
                throw new ProductServiceException("Stock quantity cannot be negative.");
            }

            // Check if product ID already exists
            try {
                productDAO.getProductById(product.getProductID());
                throw new ProductServiceException("Product with ID already exists.");
            } catch (ProductDAOException e) {
                // Expected if not found, continue
            }

            // Check for duplicate name in the same category
            List<Product> allProducts = productDAO.getAllProducts();
            for (Product p : allProducts) {
                if (p.getName().equalsIgnoreCase(product.getName()) &&
                    p.getCategory().equalsIgnoreCase(product.getCategory())) {
                    throw new ProductServiceException("A product with the same name already exists in this category.");
                }
            }

            productDAO.addProduct(product);
        } catch (ProductDAOException e) {
            throw new ProductServiceException("Failed to add product: " + e.getMessage());
        }
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param productId the ID of the product to retrieve
     * @return the product object
     * @throws ProductServiceException if product is not found or input is invalid
     */
    public Product getProductById(int productId) throws ProductServiceException {
        try {
            if (productId <= 0) {
                throw new ProductServiceException("Invalid Product ID.");
            }
            return productDAO.getProductById(productId);
        } catch (ProductDAOException e) {
            throw new ProductServiceException("Product not found: " + e.getMessage());
        }
    }

    /**
     * Retrieves a list of all products.
     *
     * @return list of all products
     * @throws ProductServiceException if there is an error fetching products
     */
    public List<Product> getAllProducts() throws ProductServiceException {
        try {
            return productDAO.getAllProducts();
        } catch (ProductDAOException e) {
            throw new ProductServiceException("Failed to retrieve product list: " + e.getMessage());
        }
    }

    /**
     * Updates an existing product after validating its details.
     *
     * @param product the updated product object
     * @throws ProductServiceException if validation fails or DAO throws an exception
     */
    public void updateProduct(Product product) throws ProductServiceException {
        try {
            Product existing = productDAO.getProductById(product.getProductID());
            if (existing == null) {
                throw new ProductServiceException("Product not found.");
            }

            if (product.getName() == null || product.getName().trim().isEmpty()) {
                throw new ProductServiceException("Product name cannot be empty.");
            }
            if (product.getPrice() <= 0) {
                throw new ProductServiceException("Product price must be greater than 0.");
            }
            if (product.getStockQuantity() < 0) {
                throw new ProductServiceException("Stock quantity cannot be negative.");
            }

            List<Product> allProducts = productDAO.getAllProducts();
            for (Product p : allProducts) {
                if (p.getProductID() != product.getProductID() &&
                    p.getName().equalsIgnoreCase(product.getName()) &&
                    p.getCategory().equalsIgnoreCase(product.getCategory())) {
                    throw new ProductServiceException("Duplicate product name in the same category.");
                }
            }

            productDAO.updateProduct(product);
        } catch (ProductDAOException e) {
            throw new ProductServiceException("Failed to update product: " + e.getMessage());
        }
    }

    /**
     * Deletes a product by its ID.
     *
     * @param productId the ID of the product to delete
     * @throws ProductServiceException if deletion fails or product does not exist
     */
    public void deleteProduct(int productId) throws ProductServiceException {
        try {
            productDAO.getProductById(productId); // ensure it exists
            productDAO.deleteProduct(productId);
        } catch (ProductDAOException e) {
            throw new ProductServiceException("Failed to delete product: " + e.getMessage());
        }
    }
}