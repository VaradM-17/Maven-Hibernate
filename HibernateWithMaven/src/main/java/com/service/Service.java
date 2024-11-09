package com.service;

import java.util.Scanner;

import com.dao.Dao;
import com.entity.User;

public class Service {
	Dao d = new Dao();
	Scanner sc = new Scanner(System.in);

	public void insert_Data() {
		User u = new User();
		System.out.print("Enter User Name: ");
		u.setName(sc.next());

		d.insert_Data(u);
	}

	public void update_Data() {
		System.out.print("Enter UserID to Update: ");
		int id = sc.nextInt();
		sc.nextLine();

		User u = new User();
		u.setId(id);
		System.out.print("Enter New User Name: ");
		u.setName(sc.nextLine());

		d.update_Data(u);
	}

	public void delete_Data() {
		System.out.print("Enter UserID to Delete: ");
		int myid = sc.nextInt();
		User u = new User();
		u.setId(myid);
		d.delete_Data(u);
	}

	public void displayAll_Data() {
		d.displayAll_Data();
	}

	public void displaySingle_Data() {
		System.out.print("Enter User ID to Display: ");
		int id = sc.nextInt();
		User u = d.displaySingle_Data(id);
		System.out.println(u);
	}
}
