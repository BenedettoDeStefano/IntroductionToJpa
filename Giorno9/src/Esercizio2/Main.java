package Esercizio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
	
	static Connection conn = null;
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/school_students?useSSL=false";
		String username = "postgres";
		String password = "1234";
		try {
			System.out.println("Connecting to PG...");

			conn = DriverManager.getConnection(url, username, password);

			System.out.println("Connected successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}

		insertStudent("Benedetto", "De Stefano", "m", 8, 7, 9, "20/02/1997");
	}

	public static void insertStudent(String name, String lastname, String gender, int avg, int min_vote, int max_vote,
			String birthdate) {
		String sqlInsert = "INSERT INTO school_students(name, lastname, gender, avg, min_vote, max_vote, birthdate)	VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement s = conn.prepareStatement(sqlInsert);
			s.setString(1, name);
			s.setString(2, lastname);
			s.setString(3, gender);
			s.setInt(4, avg);
			s.setInt(5, min_vote);
			s.setInt(6, max_vote);
			s.setString(7, birthdate);
			s.execute();
		} catch (SQLException e) {
			e.printStackTrace();



		}
		}
}
