package com.example.BookResourcedemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookInsert {

    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/BookAPI";
        String username = "root";
        String password = "niri2214";

        // SQL query to insert a book
        String sql = "INSERT INTO Books (title, author) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the values for the PreparedStatement parameters
            pstmt.setString(1, "The Great Gatsby");
            pstmt.setString(2, "F. Scott Fitzgerald");

            // Execute the query
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
