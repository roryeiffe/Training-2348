package org.example.ooppillars.inheritance;

public class Animal {
    // fields, all Animal instances and children of the Animal class will have these fields:
    double weight;
    int eyes;
    int legs;

    String species;
    String sound;

    boolean warmBlooded;

    public Animal(double weight, int eyes, int legs, String species, String sound, boolean warmBlooded) {
        // taking the value of weight that was passed in to the constructor and then assigning it to the current instance
        this.weight = weight;
        this.eyes = eyes;
        this.legs = legs;
        this.species = species;
        this.sound = sound;
        this.warmBlooded = warmBlooded;

    }

    public Animal() {

    }


    public void speak() {
        // the "this" keyword refers to the current instance of the animal:
        System.out.println("This animal says, " + this.sound);
    }

    public void speak_specific() {
        System.out.println("This " + this.species + " says, " + this.sound);
    }
}
