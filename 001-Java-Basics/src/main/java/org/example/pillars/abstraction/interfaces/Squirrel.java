package org.example.pillars.abstraction.interfaces;

public class Squirrel implements LandAnimal{
    @Override
    public void walk() {
        System.out.println("Squirrel walking.");
    }

    @Override
    public void run() {
        System.out.println("Squirrel running");
    }
}
