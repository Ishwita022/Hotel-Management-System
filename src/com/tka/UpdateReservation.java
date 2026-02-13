package com.tka;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateReservation {
public static void updateReservation(Connection con, Scanner sc) {
	
	try {
		System.out.print("Enter reservation ID to update: ");
		int resId= sc.nextInt();
		sc.nextLine();
		
		if(!ReservationExists.reservationExists(con, resId)) {
			System.out.println("Reservation not fpund for the given ID.");
			return;
		}
		
		System.out.print("Enter Guest name: ");
		String new_name = sc.nextLine();
		
		System.out.print("Enter Room number: ");
		int new_roomNo = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Contact Number: ");
		String new_contactNo = sc.nextLine();
		
		 String sql = "UPDATE reservations SET guest_name = '" + new_name + "', " +
                 "room_no = " + new_roomNo + ", " +
                 "contact_no = '" + new_contactNo + "' " +
                 "WHERE res_id = " + resId;
		 
		 try(Statement stmt = con.createStatement()){
			 int affectRows = stmt.executeUpdate(sql);
			 if (affectRows>0) {
				System.out.println("Reservation updated successfully!");
			} else {
System.out.println("Reservation update failed.");
			}
		 }
	}catch (SQLException e) {
		e.printStackTrace();
	}
}
}
