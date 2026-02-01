package main.java.com.example;

public class Calculator {

    public int calculate(int a, int b, String operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }
        
        switch (operation.toLowerCase()) {
            case "add":
            case "add-again":
                return add(a, b);
            case "sub":
            case "sub-again":
                return subtract(a, b);
            case "mul":
                return multiply(a, b);
            case "div":
                return divide(a, b);
            case "mod":
                return modulo(a, b);
            case "pow":
                return power(a, b);
            default:
                throw new IllegalArgumentException("Unknown operation: " + operation);
        }
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    public int modulo(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Modulo by zero");
        }
        return a % b;
    }

    public int power(int base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Negative exponents not supported for integer power");
        }
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
}