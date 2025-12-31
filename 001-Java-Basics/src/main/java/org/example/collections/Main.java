package org.example.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        System.out.println("=================================(Lists)");

        //ArrayList - one of the most general purpose collections. Very Array-ish

        ArrayList<Pokemon> pokemonList = new ArrayList<>();

        //use the .add() method to add Pokemon to the ArrayList
        pokemonList.add(new Pokemon("Mudkip", 5));
        pokemonList.add(new Pokemon("Eevee", 5));
        pokemonList.add(new Pokemon("Shoe", 99));
        pokemonList.add(new Pokemon("Gengar", 50));
        pokemonList.add(new Pokemon("Charizard", 65));
        pokemonList.add(new Pokemon("Totodile", 15));

        //Print out the List of Pokemon
        System.out.println(pokemonList);

        //We can access specific elements of the List with the .get() method
        System.out.println("First Pokemon: " + pokemonList.get(0));
        //size() returns an int representing the number of elements in the List
        System.out.println("Last Pokemon: " + pokemonList.get(pokemonList.size() - 1));

        //We can use the set() method to change an element by its index
        pokemonList.set(0, new Pokemon("Swampert", 40));

        //forEach() allows us to execute some logic FOR EACH element in the List
        //notice the syntax here (pokemon -> ...) this is called a "lambda". It's like a shorthand method
        pokemonList.forEach(pokemon -> pokemon.fight(new Pokemon("Magikarp", 1)));

        System.out.println("=============================================(Sets)");

        //HashSet - A general-purpose set, no crazy rules besides the rules of a set
        //(No duplicates, no defined order, no index, hence no get() method)

        HashSet<Pokemon> pokemonSet = new HashSet<>();

        //add a few Pokemon including a duplicate
        pokemonSet.add(new Pokemon("Pikachu", 25));
        pokemonSet.add(new Pokemon("Pikachu", 25));
        pokemonSet.add(new Pokemon("Snorlax", 100));
        pokemonSet.add(new Pokemon("Jigglypuff", 20));

        //Sets don't allow duplicates...
        System.out.println(pokemonSet);
        //So why are there two Pikachus?? We used the "new" keyword so the Pikachus are identical, but different objects

        //Let's define and add two of the same Pokemon object
        Pokemon mew = new Pokemon("Mew", 70);
        pokemonSet.add(mew);
        pokemonSet.add(mew);

        //Print it out again - only one Mew! Also, notice the arbitrary order
        System.out.println(pokemonSet);

        //Remember, no get() since there's no index
        //pokemonSet.get(0);

        //We CAN use contains() to see if a certain element exists in the Set
        if(pokemonSet.contains(mew)){
            System.out.println("The Set contains() Mew");
        }


        System.out.println("==========================================(Queues)");

        //LinkedList - A Collection that implements both List AND Queue
        //Queues follow FIFO (First In First Out) ordering, so we can only access/remove the element at the 0th index

        LinkedList<Pokemon> pokemonQueue = new LinkedList<>();

        //Add some Pokemon to the Queue
        pokemonQueue.add(new Pokemon("Bulbasaur", 5));
        pokemonQueue.add(new Pokemon("Squirtle", 5));
        pokemonQueue.add(new Pokemon("Charmander", 5));

        System.out.println("Welcome to the Pokemon Center: " + pokemonQueue);

        //peek() allows us to get the first element, but doesn't manipulate it
        System.out.println("The next Pokemon in line is: " + pokemonQueue.peek().getName());

        //poll() allows us to get AND remove the first element
        System.out.println("Now serving: " + pokemonQueue.poll().getName());

        //one last peek just to prove the first element was removed
        System.out.println("The next Pokemon in line is: " + pokemonQueue.peek().getName());

        System.out.println("=========================================(Maps)");

        //HashMap - General use Map, stores data in key-value pairs

        HashMap<Integer, String> trainers = new HashMap<>();

        //we can add to a Map with .put()
        trainers.put(1, "Ash");
        trainers.put(2, "Misty");
        trainers.put(3, "Brock");

        System.out.println("Our trainers are: " + trainers);

        //We can access values by their key with .get()
        System.out.println("Our second trainer is: " + trainers.get(2));
        //This is not getting by index!!! It's getting by key

        /* Why are using Integer instead of int??

            Integer is a WRAPPER CLASS - the object representation of the primitive int type.
            There is a wrapper class for each primitive in Java for cases when only Objects are allowed
            Collections and Maps, for instance, only allow objects. So we need to Wrapper classes.

            Specifically, Collections and Maps only allow objects because GENERICS only allow objects

         */

    }

}
