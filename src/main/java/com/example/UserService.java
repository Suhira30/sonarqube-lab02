package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class UserService {

    private static final String DB_URL = "jdbc:mysql://localhost/db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = System.getenv().getOrDefault("DB_PASSWORD", "admin123");

    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    public void findUser(String username) throws SQLException {
        String query = "SELECT id, name, email FROM users WHERE name = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                boolean found = false;
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    if (LOGGER.isLoggable(Level.INFO)) {
                        LOGGER.log(Level.INFO, "Found user: id={0}, name={1}, email={2}",
                                new Object[] { id, name, email });
                    }
                    found = true;
                }
                if (!found && LOGGER.isLoggable(Level.FINE)) {
                    LOGGER.fine("No user found with name: " + username);
                }
            }
        }
    }

    public void notUsed() {
        System.out.println("I am never called");
    }

    public void deleteUser(String username) throws SQLException {
        String query = "DELETE FROM users WHERE name = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, username);
            ps.executeUpdate();
        }
    }
}
