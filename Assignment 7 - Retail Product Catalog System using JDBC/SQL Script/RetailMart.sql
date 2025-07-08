#Assignment 7- Retail Mart Product Catalog System using JDBC
# PART 1 - Creating Database RetailDB

CREATE DATABASE RetailDB;
USE RetailDB;

# PART 2 - Creating Table products 

CREATE TABLE products(
productId INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(100) NOT NULL,
category VARCHAR(50) NOT NULL,
price DOUBLE NOT NULL,
stockQuantity INT NOT NULL
);


SHOW DATABASES;
DESCRIBE products;

SELECT * FROM products;
