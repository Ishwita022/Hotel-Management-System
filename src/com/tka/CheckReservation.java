package com.tka;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CheckReservation {
	public static void checkReservation(Connection con) {
		String sql = "SELECT res_id, guest_name, room_no, contact_no, res_date FROM reservations";

		try (Statement stmt = con.createStatement(); ResultSet res = stmt.executeQuery(sql)) {
			System.out.println("Current Reservations: ");
			System.out.println(
					"+----------------+-----------------+---------------+------------------+-----------------------+");
			System.out.println(
					"| Reservation ID |      Guest      |   Room Number |  Contact Number  |    Reservation Date   |");
			System.out.println(
					"+----------------+-----------------+---------------+------------------+-----------------------+");

			while (res.next()) {
				int resId = res.getInt("res_id");
				String guestName = res.getString("guest_name");
				int roomNo = res.getInt("room_no");
				String contactNo = res.getString("contact_no");
				String resDate = res.getTimestamp("res_date").toString();

				System.out.printf("| %-14d | %-15s | %-13d | %-16s | %-15s |\n", resId, guestName, roomNo, contactNo,
						resDate);

			}
			System.out.println(
					"+----------------+-----------------+---------------+------------------+-----------------------+");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
