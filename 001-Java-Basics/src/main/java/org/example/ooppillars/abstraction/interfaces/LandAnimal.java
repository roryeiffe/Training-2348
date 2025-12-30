package org.example.ooppillars.abstraction.interfaces;

public interface LandAnimal {
    public void walk();
    public void run();

    // Typically, can't have concrete methods in interfaces but the default keyword allows us to do this:
    public default void speak() {
        System.out.println("Animal is speaking.");
    }
}
