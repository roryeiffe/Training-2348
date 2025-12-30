package org.example.pillars.polymorphism;

// Overloading - changing the parameters but keeping the name same
public class Calculator {

    public static int add(int a, int b) {
        return a + b;
    }

    // changing the number of parameters:
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    // changing the types of parameters:
    public static double add(double a, double b) {
        return a + b;
    }

    public static double add(int a, double b) {
        return a + b;
    }

    public static double add(double a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(Calculator.add(3,4));
        System.out.println(Calculator.add(3.4, 1.2));
        System.out.println(Calculator.add(3, 4.5));
        System.out.println(Calculator.add(3.5, 4));
    }
}
