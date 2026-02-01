package main.java.com.example;

public class Calculator {

    public int calculate(int a, int b, String op) {
        return switch (op) {
            case "add", "add-again" -> a + b;
            case "sub", "sub-again" -> a - b;
            case "mul" -> a * b;
            case "div" -> (b == 0) ? 0 : a / b;
            case "mod" -> a % b;
            case "pow" -> {
                int res = 1;
                for (int i = 0; i < b; i++)
                    res *= a;
                yield res;
            }
            default -> 0;
        };
    }

    public int addNumbers(int x, int y) {
        return x + y;
    }

    public int addAgain(int a, int b) {
        return a + b;
    }

    public int sumValues(int a, int b) {
        return a + b;
    }
}
