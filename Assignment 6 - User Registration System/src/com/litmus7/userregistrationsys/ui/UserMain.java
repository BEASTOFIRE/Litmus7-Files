package com.litmus7.userregistrationsys.ui;

import com.litmus7.userregistrationsys.controller.UserController;
import com.litmus7.userregistrationsys.dao.UserInputDAO;
import com.litmus7.userregistrationsys.dto.User;
import com.litmus7.userregistrationsys.dto.Response;
import com.litmus7.userregistrationsys.service.UserRegistrationService;
import java.util.Scanner;

public class UserMain {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		UserRegistrationService userService = new UserRegistrationService();
		UserInputDAO userDAO = new UserInputDAO();
		UserController control = new UserController(userDAO, userService);
		Response response=new Response();
		String choice1;
		do {
			System.out.println("---User Registration Portal---\n");
			System.out.println("1. Register as a new User.\n");
			System.out.println("2.Show User Details.\n");
			System.out.println("Enter your choice: 1/2\n");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:

				System.out.println("Enter the User Details. \n" + "Username: ");
				String username = sc.nextLine();

				System.out.println("\n" + "age: ");
				int age = sc.nextInt();
				sc.nextLine();

				System.out.println("\n" + "password: ");
				String password = sc.nextLine();

				System.out.println("\n" + "email: ");
				String email = sc.nextLine();
				User user = new User(username, age, email, password);

				response=control.validateUserInput(user);
				System.out.println(response.getMessage());

				break;
			case 2:
				System.out.println("Enter Username: \n");
				username = sc.nextLine();
				response = control.returnUserDetails(username);
				System.out.println(response.getMessage());
				System.out.println(response.getData());
				break;
				
			default:
				System.out.println("Invalid Choice.\n");
			}
			System.out.println("Would you like to continue? y/n \n");
			choice1 = sc.nextLine();

		} while (choice1.equalsIgnoreCase("y"));
	}
}
