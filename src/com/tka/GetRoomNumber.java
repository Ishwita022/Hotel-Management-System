package com.tka;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GetRoomNumber {
public static void getRoomNumber(Connection con, Scanner sc){
	try {
		System.out.print("Enter Reservation ID: ");
		int res_id = sc.nextInt();
		System.out.println("Enter Guest Name: ");
		String guest_name = sc.next();
		
		String sql = "SELECT room_no FROM reservations "+
		"WHERE res_id= "+res_id+ " AND guest_name = '"+guest_name+"'";
		
		
		try(Statement stmt = con.createStatement(); 
			ResultSet res = stmt.executeQuery(sql)){
				if(res.next()) {
					int roomNo = res.getInt("room_no");
					System.out.println("Room number for Reservation ID " +res_id+ "and Guest "+guest_name+ " is in: " +roomNo);

				}else {
					System.out.println("Reservation not found for given ID and guest name.");
					
				}
			}
		
	}catch (SQLException e) {
		e.printStackTrace();
	}
}
}
