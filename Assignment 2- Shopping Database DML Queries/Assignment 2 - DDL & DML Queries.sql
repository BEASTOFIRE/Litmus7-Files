#Assignment 2- Customer Database With DML Queries
# PART 1 - Creating tables

CREATE DATABASE shops;
use shops;

CREATE TABLE customers(
	customer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    email VARCHAR(100),
    city VARCHAR(30),
    signup_date DATE NOT NULL
    );

DESCRIBE customers;    

CREATE TABLE orders(
	order_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    order_date DATE NOT NULL,
    total_amt DECIMAL(10,2),
    FOREIGN KEY(customer_id) REFERENCES customers(customer_id)
		ON DELETE CASCADE
        ON UPDATE CASCADE
    );

DESCRIBE orders;

CREATE TABLE products(
	product_id	INT PRIMARY KEY,
    product_name VARCHAR(100),
    category VARCHAR(50),
    price DECIMAL(10,2)
    );

DESCRIBE products;

CREATE TABLE order_details(
	order_dtl_id INT PRIMARY KEY,
    order_id INT,
    product_id INT,
    quantity INT,
    price DECIMAL(10,2),
    FOREIGN KEY (order_id) REFERENCES orders(order_id)
		ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(product_id)
		ON DELETE CASCADE
        ON UPDATE CASCADE
    );

ALTER TABLE order_details ADD UNIQUE (order_id,product_id);

DESCRIBE order_details;

#DATA ENTRY

INSERT INTO customers (name, email, city, signup_date) VALUES
('Alice Thomas', 'alice@gmail.com', 'Bangalore', '2023-06-01'),
('Rahul Menon', 'rahul.menon@gmail.com', 'Kochi', '2024-06-03'),
('Meera Das', 'meera.das@gmail.com', 'Chennai', '2024-06-05'),
('John Mathew', 'john.mathew@gmail.com', 'Mumbai', '2023-06-07'),
('Sara George', 'sara.george@gmail.com', 'Delhi', '2024-06-10');

INSERT INTO customers (name, email, city, signup_date) VALUES
('David Lynch', 'dave.lyn@gmail.com', 'Delhi', '2023-11-24');

INSERT INTO orders (customer_id, order_date, total_amt) VALUES
(1, '2025-05-05', 5500.00),
(2, '2025-04-06', 300.00),
(3, '2025-06-02', 1250.00),
(4, '2025-05-19', 750.00),
(5, '2025-06-07', 9000.00);



INSERT INTO products (product_id, product_name, category, price) VALUES
(101, 'Wireless Mouse', 'Electronics', 250.00),
(102, 'USB Keyboard', 'Electronics', 300.00),
(103, 'Water Bottle', 'Home & Kitchen', 150.00),
(104, 'Notebook', 'Stationery', 50.00),
(105, 'Bluetooth Speaker', 'Electronics', 600.00);
INSERT INTO products (product_id, product_name, category, price) VALUES
(106, 'Massager', 'Electronics', 2000.00);

INSERT INTO order_details (order_dtl_id, order_id, product_id, quantity, price) VALUES
(1, 1, 101, 1, 250.00),
(2, 1, 104, 2, 100.00),
(3, 2, 102, 1, 300.00),
(4, 3, 105, 2, 1200.00),
(5, 4, 103, 1, 150.00);


# PART 2- DML Queries

# Basic Queries
# 1. Get the list of all customers.
SELECT * FROM customers;

# 2. Find all orders placed in the last 30 days.
SELECT * FROM orders WHERE order_date>=CURRENT_DATE-30;

# 3. Show product names and their prices.
SELECT product_name, price FROM products;

# 4. Find the total number of products in each category.
SELECT COUNT(category) "No. of Products", category FROM products GROUP BY category;

# Filtering and Conditions

# 5. Get all customers from the city 'Mumbai'.
SELECT * FROM customers WHERE city='Mumbai';

# 6. Find orders with a total amount greater than ₹5000.
SELECT * FROM orders WHERE total_amt>5000;

#7. List customers who signed up after '2024-01-01'.
SELECT * FROM customers WHERE signup_date>'2024-01-01';

# Joins
# 8. Show all orders along with the customer's name.
SELECT c.name, o.* FROM customers c RIGHT JOIN orders o ON c.customer_id=o.customer_id;

# 9. List products purchased in each order.
SELECT p.*, o.total_amt as 'Total Order Price', od.quantity FROM order_details od JOIN products p ON od.product_id=p.product_id JOIN orders o ON od.order_id=o.order_id;

# 10. Find customers who have never placed an order.
SELECT c.* FROM customers c LEFT JOIN orders o ON c.customer_id=o.customer_id WHERE o.customer_id is NULL;

# Aggregation and Grouping
# 11. Find the total amount spent by each customer.
SELECT SUM(o.total_amt), o.customer_id, c.name FROM orders o INNER JOIN customers c ON o.customer_id=c.customer_id GROUP BY customer_id;

# 12. Which product has been sold the most (by quantity)?
SELECT SUM(od.quantity) AS 'total_quantity', p.product_name, p.product_id FROM order_details od INNER JOIN products p ON od.product_id=p.product_id GROUP BY od.product_id ORDER BY total_quantity desc LIMIT 1; 

# 13. Find the average order value for each customer.
SELECT AVG(o.total_amt), c.name, c.customer_id FROM orders o INNER JOIN customers c ON c.customer_id=o.customer_id GROUP BY c.customer_id;

# 14. Total sales amount per product category.
SELECT p.category, SUM(od.quantity * od.price) AS total_sales FROM order_details od JOIN products p ON od.product_id = p.product_id GROUP BY p.category;

# Subqueries
#15. Find customers who spent more than the average spending
SELECT c.customer_id, c.name, SUM(o.total_amt) AS spent_amt 
FROM customers c JOIN orders o ON c.customer_id = o.customer_id GROUP BY c.customer_id, c.name
HAVING SUM(o.total_amt) > (
    SELECT AVG(spent_amt) FROM (
        SELECT SUM(total_amt) AS spent_amt
        FROM orders
        GROUP BY customer_id
    ) as cust_total
);

# 16. List products that have never been ordered.
SELECT p.product_id, p.product_name FROM products p LEFT JOIN order_details od ON p.product_id = od.product_id WHERE od.product_id IS NULL;

# 17. Find the most recent order for each customer.
SELECT o.customer_id, c.name, MAX(o.order_date) AS most_recent_order_date FROM orders o JOIN customers c ON o.customer_id = c.customer_id GROUP BY o.customer_id, c.name;

# Advanced Queries
# 18. Rank customers by total spending (highest first).
SELECT c.customer_id, c.name, SUM(o.total_amt) AS total_spent FROM customers c
JOIN orders o ON c.customer_id = o.customer_id
GROUP BY c.customer_id, c.name
ORDER BY total_spent DESC;

# 19. Get the top 3 customers based on the number of orders placed.
SELECT c.customer_id, c.name, COUNT(o.order_id) AS order_count FROM customers c JOIN orders o ON c.customer_id = o.customer_id 
GROUP BY c.customer_id, c.name
ORDER BY order_count DESC
LIMIT 3;

# 20. For each product, find how many unique customers have purchased it.
SELECT p.product_id, p.product_name, COUNT(DISTINCT o.customer_id) AS unique_customers
FROM products p
JOIN order_details od ON p.product_id = od.product_id
JOIN orders o ON od.order_id = o.order_id
GROUP BY p.product_id, p.product_name;
