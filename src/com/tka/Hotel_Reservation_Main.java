package com.tka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Hotel_Reservation_Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		  final String url = "jdbc:mysql://localhost:3306/hotel_db";
		 final	String user = "root";
		 final String pass = "root";

		try {
			Class.forName("com.sql.cj.jdbc.Driver");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			Connection con = DriverManager.getConnection(url, user, pass);
			while (true) {
				Scanner sc = new Scanner(System.in);
				System.out.println("***********HOTEL MANAGEMENT SYSTEM**********");
				System.out.println("1. Reserve Room");
				System.out.println("2. Check Reservation");
				System.out.println("3. Get Room Number.");
				System.out.println("4. Update Reservation details.");
				System.out.println("5. Delete Reservation");
				System.out.println("0. Exit");
				System.out.println();
				System.out.print("Enter your Choice: ");
				int choice = sc.nextInt();
ReservationExists.reservationExists(con, choice);
				switch (choice) {
				case 1:
                    ReserveRoom.reserveRoom(con, sc);
					break;

				case 2:
                       CheckReservation.checkReservation(con);
					break;
				case 3:
                      GetRoomNumber.getRoomNumber(con, sc);
					break;
				case 4:
                      UpdateReservation.updateReservation(con, sc);
					break;
				case 5:
                      DeleteReservation.deleteReservation(con, sc);
					break;
				case 0:
					Exit.exit();
					sc.close();
					return;
					
				default:
					System.out.println("Sorry Your choice is Invalid.");
					break;
				}
			}

		} catch (Exception e) {
System.out.println(e.getMessage());
		}
//		}catch (InterruptedException e) {
//			// TODO: handle exception
//			throw new RuntimeException(e);
//		}
	}

}
