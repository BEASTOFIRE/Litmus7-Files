#Assignment 6- User Registration System using JDBC
# PART 1 - Creating Database userinfo

CREATE DATABASE userinfo;
use userinfo;

# PART 2 - Creating Table users 

CREATE TABLE users(
user_id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(100) NOT NULL UNIQUE,
age INT CHECK(age BETWEEN 18 AND 60)NOT NULL,
email VARCHAR(100) NOT NULL UNIQUE CHECK (email LIKE '%@%.%'),
password VARCHAR(255)NOT NULL CHECK(LENGTH(PASSWORD)>6) UNIQUE
);


SHOW TABLES;
DESCRIBE users;