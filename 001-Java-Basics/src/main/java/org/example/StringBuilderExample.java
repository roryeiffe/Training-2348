package org.example;

public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("stranger things");

        stringBuilder.reverse();
        System.out.println(stringBuilder);
        stringBuilder.reverse();

        stringBuilder.append(" 5");

        System.out.println(stringBuilder);
    }
}
