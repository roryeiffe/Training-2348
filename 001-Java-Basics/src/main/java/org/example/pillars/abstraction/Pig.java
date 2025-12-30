package org.example.pillars.abstraction;

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
