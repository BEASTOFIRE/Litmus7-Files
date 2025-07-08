package com.litmus7.retailmart.ui;

import java.util.Scanner;
import com.litmus7.retailmart.controller.ProductController;
import com.litmus7.retailmart.dao.ProductDAOImpl;
import com.litmus7.retailmart.dto.Product;
import com.litmus7.retailmart.dto.Response;

/**
 * Main UI class for interacting with the RetailMart Product system.
 * Acts as a menu-driven console program for CRUD operations on products.
 */
public class ProductMain {

	private static Scanner sc = new Scanner(System.in);  // Scanner for user input

	public static void main(String[] args) {
		ProductDAOImpl productDAO = new ProductDAOImpl();  // DAO object to interact with DB
		Product product = new Product();                    // Product object used for operations
		Response response = new Response();                 // Response object to capture controller results

		ProductController control = new ProductController(productDAO, product);  // Controller initialization
		int choice;
		String choice1;

		do {
			// Display menu options
			System.out.println("---RetailMart Product Portal---\n");
			System.out.println("1. Add Product \n");
			System.out.println("2. View Product by ID\n");
			System.out.println("3. View All Products\n");
			System.out.println("4. Update Product \n");
			System.out.println("5. Delete Product\n");
			System.out.println("6. Exit\n");
			System.out.println("Enter your choice\n");

			choice = sc.nextInt();
			sc.nextLine(); // consume newline

			switch (choice) {
			case 1:
				// Add Product
				System.out.println("\n---Enter Product Details---");
				System.out.println("\nEnter Product ID: ");
				int productId = sc.nextInt();
				sc.nextLine();
				System.out.println("\nEnter Product Name: ");
				String name = sc.nextLine();
				System.out.println("\nEnter Product Category: ");
				String category = sc.nextLine();
				System.out.println("\nEnter Product Price: ");
				double price = sc.nextDouble();
				System.out.println("\nEnter Product Stock Quantity: ");
				int stockQuantity = sc.nextInt();
				sc.nextLine();
				
				// Create product and call controller
				product = new Product(productId, name, category, price, stockQuantity);
				response = control.validateAddProduct(product);
				System.out.println(response.getMessage());
				break;

			case 2:
				// View product by ID
				System.out.println("\nEnter Product ID: ");
				productId = sc.nextInt();
				sc.nextLine();
				response = control.validateGetProduct(productId);
				System.out.println(response.getMessage());
				System.out.println(response.getData());
				break;

			case 3:
				// View all products
				System.out.println("\n---All Product Details---");
				response = control.validateGetAllProducts();
				System.out.println(response.getMessage());
				System.out.println(response.getData());
				break;

			case 4:
				// Update product
				System.out.println("\nEnter Product ID: ");
				productId = sc.nextInt();
				sc.nextLine();
				Response<Product> responseData = control.validateGetProduct(productId);

				if (responseData.isSuccess()) {
					product = responseData.getData();
					productId = product.getProductID();

					// Display current values for easy editing
					System.out.println("\nEnter new Product Name (current name: " + product.getName() + " ): ");
					name = sc.nextLine();
					System.out.println("\nEnter new Product Category (current Category: " + product.getCategory() + " ): ");
					category = sc.nextLine();
					System.out.println("\nEnter Product Price (current Price: " + product.getPrice() + " ): ");
					price = sc.nextDouble();
					System.out.println("\nEnter Product Stock Quantity (current Stock Quantity: " + product.getStockQuantity() + " ): ");
					stockQuantity = sc.nextInt();
					sc.nextLine();

					// Create updated product and call update
					product = new Product(productId, name, category, price, stockQuantity);
					response = control.validateUpdateProduct(product);
					System.out.println(response.getMessage());
				} else {
					System.out.println(responseData.getMessage());
				}
				break;

			case 5:
				// Delete product
				System.out.println("\nEnter Product ID: ");
				productId = sc.nextInt();
				sc.nextLine();
				response = control.validateDeleteProduct(productId);
				System.out.println(response.getMessage());
				break;

			case 6:
				// Exit application
	            System.out.println("\nExit Program");
	            System.exit(0);
	            break;

			default:
				// Invalid menu choice
				System.out.println("\nInvalid Choice");
				break;
			}

			// Ask user if they want to continue
			System.out.println("\nDo you want to Continue ? y/n\n");
			choice1 = sc.nextLine();

		} while (choice1.equalsIgnoreCase("y"));  // loop until user says no
	}
}
