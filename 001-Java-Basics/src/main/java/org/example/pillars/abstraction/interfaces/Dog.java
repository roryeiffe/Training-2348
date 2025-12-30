package org.example.pillars.abstraction.interfaces;

public class Dog implements LandAnimal{
    public void walk() {
        System.out.println("Walking the dog.");
    }
    public void run() {
        System.out.println("Dog got out and is running.");
    }
}
