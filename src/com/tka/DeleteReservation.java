package com.tka;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteReservation {
public static void deleteReservation(Connection con, Scanner sc) {
try {
	System.out.print("Enter reservation ID to delete: ");
	int res_id= sc.nextInt();
	
	if(!ReservationExists.reservationExists(con, res_id)) {
		System.out.println("Reservation not fpund for the given ID.");
		return;
	}
	
	String sql = "DELETE FROM reservations WHERE res_id= "+res_id;
	
	try (Statement stmt = con.createStatement()){
		 int affectRows = stmt.executeUpdate(sql);
		 if (affectRows>0) {
			System.err.println("Reservation deleted successfully!");
		} else {
System.err.println("Reservation update failed.");
		}
	 }
		
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
}

