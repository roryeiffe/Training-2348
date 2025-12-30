package org.example.fundamentals;

public class Casting {
    public static void main(String[] args) {
        // Primitive Casting:
        // Widening, going from int to double
        // No data loss
        double x = 3;
        System.out.println(x);

        // Narrowing
        // Note that we explicitly cast with (int)
        // We also lose the .01
        int y = (int) 3.01;
        System.out.println(y);




    }
}
