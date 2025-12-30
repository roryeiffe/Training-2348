package org.example.pillars.inheritance;

public class Mammal extends Animal{

    // add a new field that is specific to Mammals but not Animals:
    int litterSize;

    public Mammal(double weight, int eyes, int legs, String species, String sound, boolean warmBlooded, int litterSize) {
        // invoke the parent constructor using the "super" keyword
        super(weight, eyes, legs, species, sound, warmBlooded);
        this.litterSize = litterSize;
    }

    public Mammal() {
        // call the default parent constructor:
        super();
    }

    // Can override methods and change their behavior
    @Override
    public void speak() {
        // the "this" keyword refers to the current instance of the animal:
        System.out.println("This mammal says, " + this.sound);
    }


}
