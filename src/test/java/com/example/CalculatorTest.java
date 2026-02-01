package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void adds() {
        assertEquals(15, new Calculator().calculate(10, 5, "add"));
    }

    @Test
    void subs() {
        assertEquals(5, new Calculator().calculate(10, 5, "sub"));
    }

    @Test
    void muls() {
        assertEquals(50, new Calculator().calculate(10, 5, "mul"));
    }

    @Test
    void divs() {
        assertEquals(2, new Calculator().calculate(10, 5, "div"));
    }

    @Test
    void divByZero() {
        assertThrows(IllegalArgumentException.class, () -> new Calculator().calculate(10, 0, "div"));
    }

    @Test
    void mods() {
        assertEquals(1, new Calculator().calculate(10, 3, "mod"));
    }

    @Test
    void invalidOp() {
        assertThrows(IllegalArgumentException.class, () -> new Calculator().calculate(10, 5, "unknown"));
    }
}
