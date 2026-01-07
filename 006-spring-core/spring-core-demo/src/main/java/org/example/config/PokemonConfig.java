package org.example.config;

import org.example.entities.Pokemon;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// This class uses Java-Based Configuration to set up Pokemon beans
@Configuration // Tells Spring that this class is a source of configuration
// for beans
public class PokemonConfig {

    // To configure a bean, we need to set up a method that returns
    // an object of the desired type (Pokemon, in this case)
    // We also need to add the @Bean annotation which specifices that the
    // returned object from this method should be registered as a bean
    @Bean(name="randomPokemon", initMethod = "init", destroyMethod = "destroy")
    @Scope("prototype") // by default, the scope is Singleton so if we want multiple instances, we need to specify the prototype scope
    public Pokemon getRandomPokemon() {
        List<String> names = new ArrayList<>();

        names.add("Bulbasaur");
        names.add("Charmander");
        names.add("Squirtle");

        Random random = new Random();

        String name = names.get(random.nextInt(names.size()));

        String type1 = "type1";
        String type2 = "type2";

        // random between 0 and 99
        int level = random.nextInt(100);

        return new Pokemon(name, name, type1, type2, level);


    }

}
