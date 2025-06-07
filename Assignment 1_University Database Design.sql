#Assignment 1- University Database and Tables

CREATE DATABASE university;
SHOW DATABASES;
USE university;


CREATE TABLE advisors(
	advisor_id INT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    email_add VARCHAR (100) UNIQUE NOT NULL,
    specialization VARCHAR(60)
    );


CREATE TABLE student(
	student_id INT PRIMARY KEY,
	name VARCHAR(30) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    dob DATE NOT NULL,
    advisor_id INT,
    FOREIGN KEY(advisor_id) REFERENCES advisors(advisor_id)
		ON DELETE SET NULL
		ON UPDATE CASCADE
    );

    
CREATE TABLE courses(
	course_code VARCHAR(20) PRIMARY KEY,
	title VARCHAR(70) UNIQUE NOT NULL,
	description VARCHAR(800),
	instructor VARCHAR(100) NOT NULL
	);

        
CREATE TABLE student_courses(
	student_id INT,
    course_code VARCHAR(20),
    PRIMARY KEY(student_id, course_code),
    FOREIGN KEY(student_id) REFERENCES student(student_id)
		ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY(course_code) REFERENCES courses(course_code)
		ON DELETE CASCADE
        ON UPDATE CASCADE
	);

        
SHOW TABLES;
    