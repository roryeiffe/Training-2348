package org.example.calculations;

public class Calculator {
    /**
     *
     * @param x first number to be added
     * @param y second number to be added
     * @return the sum of the 2 parameters
     */
    public int add(int x, int y) {
        return x + y;
    }

    /**
     *
     * @param x
     * @param y
     * @return the difference between the 2 parameters:
     */
    public int subtract(int x, int y) {
        return x-y;
    }

    public int multiply(int x, int y) {
        return x*y;
    }

    public int[] firstFiveNumbers() {
        int numbers[] = {1,2,3,4,5};
        return numbers;
    }
}
