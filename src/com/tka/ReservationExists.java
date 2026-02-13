package com.tka;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ReservationExists {
public static boolean reservationExists(Connection con, int res_id ) {
	try {
		String sql = "SELECT res_id FROM reservations WHERE res_id = "+res_id;
	try (Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(sql)){
		return res.next();
	}
	}catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
}
}
