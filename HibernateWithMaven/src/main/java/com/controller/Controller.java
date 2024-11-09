package com.controller;

import java.util.Scanner;
import com.service.Service;

public class Controller {
	public static void main(String[] args) {
		Service s = new Service();
		Scanner sc = new Scanner(System.in);
		int option;

		do {
			System.out.println("\n*************************************************");
			System.out.println("            😊 User Management 😊       ");
			System.out.println("*************************************************");
			System.out.println("  1. ➤ Insert New User Data");
			System.out.println("  2. ➤ Update Existing User Data");
			System.out.println("  3. ➤ Delete User Data");
			System.out.println("  4. ➤ Display All User Records");
			System.out.println("  5. ➤ Display Single User Record");
			System.out.println("  6. ➤ Exit Program");
			System.out.println("*************************************************");
			System.out.print("👉 Choose Option: ");

			option = sc.nextInt();

			switch (option) {
			case 1:
				s.insert_Data();
				break;

			case 2:
				s.update_Data();
				break;

			case 3:
				s.delete_Data();
				break;

			case 4:
				s.displayAll_Data();
				break;

			case 5:
				s.displaySingle_Data();
				break;

			case 6:
				System.out.println("Program Exited.....");
				break;

			default:
				System.out.println("Invalid choice! Please try again.");
				break;
			}
		} while (option != 6);

		sc.close();
	}
}
