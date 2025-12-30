package org.example.ooppillars.abstraction;

public class Pig extends Animal{

    @Override
    public void speak() {
        System.out.println("Oink!");
    }

    @Override
    public int getLegs() {
        return 4;
    }
}
