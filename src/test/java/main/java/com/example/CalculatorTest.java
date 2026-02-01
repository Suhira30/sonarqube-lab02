package main.java.com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void adds() {
        assertEquals(15, new Calculator().calculate(10, 5, "add"));
        assertEquals(5, new Calculator().calculate(10, 5, "sub"));
    }
}