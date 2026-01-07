package com.revature;

// Create a functional interface (an interface with 1 astract method)
interface Raise {
    // as with all abstract methods, we define the expected behavior, but not how it's done (we will leave
    // this to the lambds expressions)
    int calculate(int x);
}


public class FunctionalInterfacesExample {
    public static void main(String[] args) {
        // declare a lambda expression using the functional interface:
        // These lambda expressions take in a single parameter and then return the calculated value from the expression
        Raise square = (int x) -> x * x;
        Raise cube = (int x) -> x * x * x;

        // call the methods:
        System.out.println(square.calculate(5));
        System.out.println(cube.calculate(7));

        // we can pass lambda expressions into other methods as parameters
        applyExpressionPrint(10, square);
        applyExpressionPrint(10, cube);
    }

    public static void applyExpressionPrint(int x, Raise raise) {
        int result = raise.calculate(x);
        System.out.println("The result is : " + result);
    }
}
