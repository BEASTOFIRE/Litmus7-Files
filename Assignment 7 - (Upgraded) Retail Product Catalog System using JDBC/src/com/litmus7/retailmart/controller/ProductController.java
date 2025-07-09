package com.litmus7.retailmart.controller;

import com.litmus7.retailmart.dto.*;
import com.litmus7.retailmart.service.ProductService;
import com.litmus7.retailmart.exceptions.ProductServiceException;

import java.util.List;

/**
 * Controller class to manage product-related operations.
 */
public class ProductController {

    /** Status code indicating a successful operation. */
    public static final int SUCCESS_STATUS_CODE = 200;

    /** Status code indicating an error during processing. */
    public static final int ERROR_STATUS_CODE = 400;

    /** Service class for business logic. */
    private ProductService productService;

    /**
     * Constructor to initialize the controller with a service implementation.
     *
     * @param productService the product service implementation
     */
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Validates and adds a product.
     *
     * @param product the product to add
     * @return response indicating success or failure
     */
    public Response<String> validateAddProduct(Product product) {
        try {
            productService.addProduct(product);
            return new Response<>("Product Inputted Successfully", SUCCESS_STATUS_CODE, true);
        } catch (ProductServiceException e) {
            return new Response<>(e.getMessage(), ERROR_STATUS_CODE, false);
        }
    }

    /**
     * Retrieves a product by ID.
     *
     * @param productId the ID of the product
     * @return response containing the product or an error message
     */
    public Response<Product> validateGetProduct(int productId) {
        try {
            Product product = productService.getProductById(productId);
            return new Response<>("Product Returned Successfully", SUCCESS_STATUS_CODE, true, product);
        } catch (ProductServiceException e) {
            return new Response<>(e.getMessage(), ERROR_STATUS_CODE, false, null);
        }
    }

    /**
     * Retrieves all products.
     *
     * @return response containing the product list or an error message
     */
    public Response<List<Product>> validateGetAllProducts() {
        try {
            List<Product> products = productService.getAllProducts();
            return new Response<>("Products Retrieved Successfully", SUCCESS_STATUS_CODE, true, products);
        } catch (ProductServiceException e) {
            return new Response<>(e.getMessage(), ERROR_STATUS_CODE, false);
        }
    }

    /**
     * Validates and updates a product.
     *
     * @param product the product with updated details
     * @return response indicating success or failure
     */
    public Response<String> validateUpdateProduct(Product product) {
        try {
            productService.updateProduct(product);
            return new Response<>("Product Updated Successfully", SUCCESS_STATUS_CODE, true);
        } catch (ProductServiceException e) {
            return new Response<>(e.getMessage(), ERROR_STATUS_CODE, false);
        }
    }

    /**
     * Validates and deletes a product by ID.
     *
     * @param productId the ID of the product to delete
     * @return response indicating success or failure
     */
    public Response<String> validateDeleteProduct(int productId) {
        try {
            productService.deleteProduct(productId);
            return new Response<>("Product Deleted Successfully", SUCCESS_STATUS_CODE, true);
        } catch (ProductServiceException e) {
            return new Response<>(e.getMessage(), ERROR_STATUS_CODE, false);
        }
    }
}
