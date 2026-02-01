package com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class UserService {

    private String password = System.getenv("DB_PASSWORD");

    private Connection connection;

    public UserService() {
        // Default constructor
    }

    public UserService(Connection connection) {
        this.connection = connection;
    }

    public void findUser(String username) throws java.sql.SQLException {
        Connection conn = this.connection;
        if (conn == null) {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", password);
        }

        String query = "SELECT name FROM users WHERE name = ?";

        try (java.sql.PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.executeQuery();
        }
    }

    public void deleteUser(String username) throws java.sql.SQLException {
        Connection conn = this.connection;
        if (conn == null) {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", password);
        }

        String query = "DELETE FROM users WHERE name = ?";
        try (java.sql.PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.executeUpdate();
        }
    }

}
