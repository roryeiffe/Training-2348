package org.example;

public class StringExample {
    public static void main(String[] args) {

        // the syntax is kind of similar to when we create primitives:
        String s = "sandwich";

        System.out.println(s.charAt(3));
        System.out.println(s.length());

        // Because both of these strings have the same value, the variables will reference the same exact String in the String pool
        String c = "cat";
        String cat = "cat";

        // We can test this out by comparing the reference (because of the string pool, these 2 variables have the same reference.
        System.out.println(c == cat);
        // Comparing the value
        System.out.println(c.equals(cat));

        // Show off comparing 2 completely different String objects
        // If we use the new keyword to define a string, this object will be created outside of the string pool
        String d = new String("cat");

        // d is not in the string pool and c is, these objects take up completely different spots in memory
        System.out.println(d == c);
        // but they still have the same value:
        System.out.println(d.equals(c));

        String s1 = "cat";
        s1 = "cats";



    }
}
