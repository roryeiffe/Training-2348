package org.example.ooppillars.abstraction.interfaces;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.walk();
        dog.run();

        // we can keep the type as LandAnimal (interface) but the object that we are instantiating is a Dog object
        // This works because every method that is defined for LandAnimal should be implemented by the Dog class (based on the "contract" of the interface)
        LandAnimal animal = new Dog();
    }
}
