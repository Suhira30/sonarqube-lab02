package main.java.com.example;

import java.util.logging.Logger;
import java.util.logging.Level;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "Calculation result: {0}", calc.calculate(10, 5, "add-again"));
        }

        UserService service = new UserService();
        service.findUser("admin");
        service.deleteUser("admin");
    }

}
