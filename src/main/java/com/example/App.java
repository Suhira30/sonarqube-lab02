package com.example;

import java.util.logging.Logger;
import java.util.logging.Level;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        // "add-again" is not a valid operator, reverting to "add"
        if (LOGGER.isLoggable(Level.INFO)) {
            try {
                // Fixed invalid operator "add-again" -> "add" to avoid IllegalArgumentException
                LOGGER.log(Level.INFO, "Calculation result: {0}", calc.calculate(10, 5, "add"));
            } catch (IllegalArgumentException e) {
                LOGGER.log(Level.SEVERE, "Calculation failed: {0}", e.getMessage());
            }
        }

        UserService service = new UserService();
        try {
            service.findUser("admin");
            // deleteUser is now implemented in UserService
            service.deleteUser("admin");
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Database connection failed (Expected during local run without DB). Error: {0}",
                    e.getMessage());
        }
    }

}
