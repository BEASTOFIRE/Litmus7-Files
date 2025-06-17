package com.litmus7.school.dto;

import java.util.Scanner;

/**
 * Represents a student with name, roll number, marks in 5 subjects. Provides
 * methods to input details, calculate total/average marks, determine grade, and
 * print a report card.
 */
public class Student {

	/** The name of the student */
    private String studentname;

	/** The roll number of the student */
	private int rollno;

	/** Array to store marks in 5 subjects */
	private double marks[] = new double[5];

	/**
	 * Inputs the student's name, roll number, and marks for 5 subjects.
	 */
	public void inputDetails() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your name: ");
		studentname = sc.nextLine();

		System.out.println("Enter your Roll Number: ");
		rollno = sc.nextInt();

		System.out.println("Enter Marks in 5 Subjects: ");
		for (int i = 0; i < 5; i++) {
			System.out.println("Subject " + (i + 1) + ":");
			marks[i] = sc.nextDouble();
		}
	}

	/**
	 * Calculates and returns the total marks.
	 * 
	 * @return total marks
	 */
	private double calculateTotal() {
		double sum = 0;
		for (double mark : marks) {
			sum += mark;
		}
		return sum;
	}

	/**
	 * Calculates and returns the average marks.
	 * 
	 * @return average marks
	 */
	private double calculateAvg() {
		return calculateTotal() / 5.0;
	}

	/**
	 * Determines and returns the grade based on average marks.
	 * 
	 * @return Grade enum
	 */
	public Grade getGrade() {
		double avg = calculateAvg();
		if (avg >= 90)
			return Grade.A;
		else if (avg >= 75)
			return Grade.B;
		else if (avg >= 60)
			return Grade.C;
		else if (avg >= 50)
			return Grade.D;
		else
			return Grade.F;
	}

	/**
	 * Prints the student's report card.
	 */
	public void printReportCard() {
		System.out.println("\n--- Report Card ---");
		System.out.println("Name: " + studentname);
		System.out.println("Roll No: " + rollno);
		System.out.println("Total Marks: " + calculateTotal());
		System.out.println("Average Marks: " + calculateAvg());
		System.out.println("Grade: " + getGrade());
		System.out.println();
	}

	/**
	 * enum representing Grades with descriptions.
	 */
	public enum Grade {
		A("Excellent"), B("Very Good"), C("Good"), D("Satisfactory"), F("Fail");

		private final String description;

		// Constructor
		private Grade(String description) {
			this.description = description;
		}

		// Getter for description
		public String getDescription() {
			return description;
		}
	}
}
