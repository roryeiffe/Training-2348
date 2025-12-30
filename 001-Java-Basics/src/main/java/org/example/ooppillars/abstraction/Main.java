package org.example.ooppillars.abstraction;

public class Main {
    public static void main(String[] args) {
        // can't instantiate an instance of object because some methods are abstract
//        Animal animal = new Animal();
//        animal.speak();


        Cow cow = new Cow();
        cow.speak();
        cow.sleep();

        Animal animal = new Cow();

        Pig pig = new Pig();
        pig.speak();
        pig.sleep();

        Cow cow2 = (Cow) animal;
        cow2.speak();
    }
}
