package org.example.pillars.inheritance;

public class Dog extends Mammal{
    String breed;

    public Dog(String breed, double weight, int litterSize) {
        // we can use the "super" keyword to invoke the parent (Mammal) constructor but we should
        // know the values of some of these fields ahead of time:
        super(weight, 2, 4, "Canis familiaris", "bark", true, litterSize);
        this.breed = breed;
    }

    @Override
    public void speak() {
        System.out.println("The dog says bark!");
    }


    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", litterSize=" + litterSize +
                ", weight=" + weight +
                ", eyes=" + eyes +
                ", legs=" + legs +
                ", species='" + species + '\'' +
                ", sound='" + sound + '\'' +
                ", warmBlooded=" + warmBlooded +
                '}';
    }

//    public void scratchEar() {
//        System.out.println("Dog is scratching ear.");
//    }
}
