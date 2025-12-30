package org.example.pillars.abstraction;

public abstract class Animal {

    // every animal should have the ability to speak
    public abstract void speak() ;

    // for every animal, we want to know how many legs they have, but we don't know the exact number
    public abstract int getLegs() ;

    // abstract classes can have concrete methods as well
    public void sleep() {
        System.out.println("ZZZ");
    }
}
