package com.litmus7.school;

import com.litmus7.school.dto.Student;
import java.util.Scanner;

public class StudentApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter how many students details you would like to have:");
		int nums = sc.nextInt();

		Student[] student = new Student[nums];

		for (int i = 0; i < nums; i++) {
			System.out.println("\nEnter Details for Student " + (i + 1) + ":");
			student[i] = new Student();
			student[i].inputDetails();
		}

		System.out.println("Would you like to print all the report Cards of the Students ? y/n");
		String choice = sc.next();

		if (choice.equals("y")) {
			for (int i = 0; i < nums; i++) {
				student[i].printReportCard();
			}
		} else {
			System.out.println("No Report Cards Printed.\n");
		}
	}

}
