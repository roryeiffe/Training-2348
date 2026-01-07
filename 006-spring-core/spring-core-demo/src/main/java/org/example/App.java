package org.example;

import org.example.config.PokemonConfig;
import org.example.entities.HelloWorld;
import org.example.entities.Order;
import org.example.entities.Pokemon;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // XML-Based Config:
        // we have some beans defined in our xml file, now we can access them:
        // BeanFactory is responsible for creating objects
        BeanFactory factoryXML = new ClassPathXmlApplicationContext("beans.xml");

        HelloWorld helloWorld = (HelloWorld) factoryXML.getBean("helloWorld");

        System.out.println(helloWorld.getMessage());

        Pokemon pokemon1 = (Pokemon) factoryXML.getBean("pokemon1");

        System.out.println(pokemon1);

        System.out.println("Annotation-Based Configuration:");


        // Annotation-based Config:
        // if we pass in the class to specify which bean, we don't need to cast it:
        Order order1 = factoryXML.getBean(Order.class);

        System.out.println(order1);

        // Java-Based Configuration

        // Non-spring way:
//        PokemonConfig pokemonConfig = new PokemonConfig();
//
//        Pokemon pokemon = pokemonConfig.getRandomPokemon();
//        System.out.println(pokemon);

        // We need a new BeanFactory/ApplicationContext that uses the Config class
        // as a configuration source ( as opposed to our xml file )
        GenericApplicationContext applicationContext = new AnnotationConfigApplicationContext(PokemonConfig.class);

        Pokemon pokemon2 = (Pokemon) applicationContext.getBean("randomPokemon");
        Pokemon pokemon3 = (Pokemon) applicationContext.getBean("randomPokemon");
        Pokemon pokemon4 = (Pokemon) applicationContext.getBean("randomPokemon");

        System.out.println(pokemon2);
        System.out.println(pokemon3);
        System.out.println(pokemon4);


    }
}
