package org.example.pillars.inheritance;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal();

        // assigning the value "Bark!" to the sound field of this animal:
        animal1.sound = "Bark!";
        animal1.species = "Dog";
        // invoking the speak method
        animal1.speak();
        animal1.speak_specific();

        Animal animal2 = new Animal(10.0, 2, 4, "dog", "ruh-roh", true);
        animal2.speak_specific();

        Mammal mammal = new Mammal(20.0, 2, 2, "Kangaroo", "Kangaroo noises", true, 1);
        mammal.speak();
        mammal.speak_specific();

        Dog dog = new Dog("Corgi", 10.0, 4);
        System.out.println(dog);

        // down-casting, converting from animal to dog:
        Dog dog2 = (Dog) animal1;
//        dog2.scratchEar();

    }
}
