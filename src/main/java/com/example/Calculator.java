package com.example;

public class Calculator {

    // Code Smell: Long method + high complexity
    private enum Operator {
        ADD("add") {
            @Override
            int apply(int a, int b) {
                return a + b;
            }
        },
        SUB("sub") {
            @Override
            int apply(int a, int b) {
                return a - b;
            }
        },
        MUL("mul") {
            @Override
            int apply(int a, int b) {
                return a * b;
            }
        },
        DIV("div") {
            @Override
            int apply(int a, int b) {
                if (b == 0)
                    throw new IllegalArgumentException("Cannot divide by zero");
                return a / b;
            }
        },
        MOD("mod") {
            @Override
            int apply(int a, int b) {
                return a % b;
            }
        };

        private final String symbol;

        Operator(String symbol) {
            this.symbol = symbol;
        }

        abstract int apply(int a, int b);

        static Operator from(String op) {
            for (Operator operator : values()) {
                if (operator.symbol.equals(op))
                    return operator;
            }
            throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }

    public int calculate(int a, int b, String op) {
        return Operator.from(op).apply(a, b);
    }

}
