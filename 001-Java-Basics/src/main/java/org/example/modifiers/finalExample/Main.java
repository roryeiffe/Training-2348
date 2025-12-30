package org.example.modifiers.finalExample;

public class Main {
    public static void main(String[] args) {
        final int x = 5;
        // Can't re-assign because x is final:
//        x = 3;

        final Book book = new Book("The Martian", "Andy Weir");
//        book = new Book("Lord of the Rings", "JRR");
        book.setName("Project Hail Mary");
    }
}
