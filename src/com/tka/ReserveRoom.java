package com.tka;

import java.sql.Statement;
import java.sql.Connection;
import java.util.Scanner;

public class ReserveRoom {
public static void reserveRoom(Connection con, Scanner sc) {
	try {
		System.out.print("Enter Guest name: ");
		String name = sc.next();
		sc.nextLine();
		System.out.print("Enter Room number: ");
		int roomNo = sc.nextInt();
		System.out.print("Enter Contact Number: ");
		String contactNo = sc.next();
		
		String sql = "INSERT INTO reservations (guest_name, room_no, contact_no) "+
		"Values ('"+name+"',"+roomNo+",'"+contactNo+"')";
		
		
		try (Statement stmt = con.createStatement()) {
			int affectRows = stmt.executeUpdate(sql);
			
			if(affectRows>0) {
				System.out.println("Reservation succesful..");
			}else {
				System.out.println("Reservation failed");
			}
		}
	} catch (Exception e) {
		e.printStackTrace();
		
	}
}
}
