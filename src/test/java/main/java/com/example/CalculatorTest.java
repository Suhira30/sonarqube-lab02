package main.java.com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void adds() {
        Calculator calc = new Calculator();
        assertEquals(15, calc.calculate(10, 5, "add"));
        assertEquals(15, calc.calculate(10, 5, "add-again"));
    }

    @Test
    void divisionByZeroReturnsZero() {
        Calculator calc = new Calculator();
        assertEquals(0, calc.calculate(10, 0, "div"));
    }
}