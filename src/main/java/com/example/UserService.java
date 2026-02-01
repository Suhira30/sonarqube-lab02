package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

    // Use environment variable for credentials to avoid hardcoding
    private static final String DB_URL = "jdbc:mysql://localhost/db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = System.getenv().getOrDefault("DB_PASSWORD", "admin123");

    // Use parameterized queries and try-with-resources to avoid SQL injection and
    // resource leaks
    public void findUser(String username) throws SQLException {
        // Avoid SELECT * — list explicit columns for clarity and performance
        String query = "SELECT id, name, email FROM users WHERE name = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // process result if needed (e.g. rs.getInt("id"), rs.getString("name"), rs.getString("email"))
                }
            }
        }
    }

    // SMELL: Unused method
    public void notUsed() {
        System.out.println("I am never called");
    }

    // Use parameterized delete with try-with-resources
    public void deleteUser(String username) throws SQLException {
        String query = "DELETE FROM users WHERE name = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, username);
            ps.executeUpdate();
        }
    }
}
