package com.example.BookResourcedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.BookResourcedemo")
public class BookResourcedemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookResourcedemoApplication.class, args);

		String url = "jdbc:mysql://localhost:3306/BookAPI";
		String username = "root";
		String password = "niri2214";


		String sql = "INSERT INTO Books (title, author) VALUES (?, ?)";

		try (Connection conn = DriverManager.getConnection(url, username, password);
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {


			pstmt.setString(1, "The Great Gatsby");
			pstmt.setString(2, "F. Scott Fitzgerald");

			int rowsAffected = pstmt.executeUpdate();
			System.out.println("Rows affected: " + rowsAffected);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
