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
        if (this.connection == null) {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", password)) {
                findUserInternal(conn, username);
            }
        } else {
            findUserInternal(this.connection, username);
        }
    }

    private void findUserInternal(Connection conn, String username) throws java.sql.SQLException {
        String query = "SELECT name FROM users WHERE name = ?";
        try (java.sql.PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.executeQuery();
        }
    }

    public void deleteUser(String username) throws java.sql.SQLException {
        if (this.connection == null) {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", password)) {
                deleteUserInternal(conn, username);
            }
        } else {
            deleteUserInternal(this.connection, username);
        }
    }

    private void deleteUserInternal(Connection conn, String username) throws java.sql.SQLException {
        String query = "DELETE FROM users WHERE name = ?";
        try (java.sql.PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.executeUpdate();
        }
    }

}
