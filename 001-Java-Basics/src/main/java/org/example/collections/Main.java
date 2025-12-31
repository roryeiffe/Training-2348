package org.example.collections;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("=============(Lists)");

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

    }

}
