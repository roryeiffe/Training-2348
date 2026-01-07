package org.example.entities;

public class HelloWorld {
    private String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HelloWorld() {

    }

    // With this constructor created, Java no longer creates a default,
    // no-args constructor so now property-based injection doesn't work
    public HelloWorld(String message) {
        this.message = message;
    }
}
