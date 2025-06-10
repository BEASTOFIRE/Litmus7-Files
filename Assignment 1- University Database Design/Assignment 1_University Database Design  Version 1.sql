#Assignment 1- University Database and Tables

CREATE DATABASE university;
SHOW DATABASES;
USE university;


CREATE TABLE advisor(
	advisor_id INT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    email_add VARCHAR (100) UNIQUE NOT NULL,
    specialization VARCHAR(60) NOT NULL
    );


CREATE TABLE student(
	student_id INT PRIMARY KEY,
	name VARCHAR(30) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    dob DATE NOT NULL,
    advisor_id INT,
    CONSTRAINT FKS_1 FOREIGN KEY(advisor_id) REFERENCES advisors(advisor_id)
		ON DELETE SET NULL
		ON UPDATE CASCADE
    );

    
CREATE TABLE course(
	course_code VARCHAR(20) PRIMARY KEY,
	title VARCHAR(70) UNIQUE NOT NULL,
	description VARCHAR(800) NOT NULL,
	instructor VARCHAR(100) NOT NULL
	);

        
CREATE TABLE student_course(
	student_id INT,
    course_code VARCHAR(20),
    enrollment_date DATE NOT NULL,
    enr_status VARCHAR(30) NOT NULL,
    PRIMARY KEY(student_id, course_code),
    CONSTRAINT FKSC_1 FOREIGN KEY(student_id) REFERENCES student(student_id)
		ON DELETE CASCADE
        ON UPDATE CASCADE,
    CONSTRAINT FKSC_2 FOREIGN KEY(course_code) REFERENCES courses(course_code)
		ON DELETE CASCADE
        ON UPDATE CASCADE
	);

        
SHOW TABLES;
    