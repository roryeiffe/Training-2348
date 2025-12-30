package org.example.fundamentals;

import java.util.Arrays;

public class ArrayExample {
    public static void main(String[] args) {
        // creating a pre-defined array:
        int [] grades = {90, 100, 80, 75};
        System.out.println(grades[0]);
        System.out.println(grades[1]);

        // allocating an array of a certain size:
        String [] foods = new String[5];

        System.out.println(foods[0]);

        foods[0] = "pizza";

        System.out.println(foods[0]);

        for(int i = 0; i < foods.length; i ++) {
            System.out.println(foods[i]);
        }

        System.out.println(Arrays.toString(grades));
    }
}
