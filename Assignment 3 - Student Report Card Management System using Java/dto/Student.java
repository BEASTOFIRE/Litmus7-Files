package com.litmus7.school.dto;
import java.util.Scanner;


public class Student {
	String std_name;
	int roll_no;
	double marks[] = new double[5];
	
	public void inputDetails() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your name: ");
		std_name=sc.nextLine();
		
		System.out.println("Enter your Roll Number: ");
		roll_no=sc.nextInt();
		
		System.out.println("Enter Marks in 5 Subjects: ");
		for (int i=0; i<5;i++) {
			System.out.println("Subject "+(i+1)+":");
			marks[i]=sc.nextDouble();
		}
	}
	
	public double calculateTotal() {
		double sum=0;
		for (int i=0; i<5;i++) {
			sum=marks[i]+sum;
		}
		return sum;
	}
	public double calculateAvg() {
		return calculateTotal() /5.0;
	}
	
	public void getGrade() {
		double avg = calculateAvg();
		if (avg >= 90)
			System.out.println("Grade A");
		else if(avg>= 75)
			System.out.println("Grade B");
		else if(avg>= 60)
			System.out.println("Grade C");
		else if(avg>= 50)
			System.out.println("Grade D");
		else
			System.out.println("Grade F");
	}
	
	public void printReportCard() {
		System.out.println("\n---Report Card---");
		System.out.println("Name :"+ std_name);
		System.out.println("Roll No: "+ roll_no);
		System.out.println("Total Marks: "+ calculateTotal());
		System.out.println("Average Marks: "+ calculateAvg());
		getGrade();
		System.out.println("\n");
	}
	
}
