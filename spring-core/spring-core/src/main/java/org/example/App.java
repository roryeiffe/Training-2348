package org.example;

import org.example.entities.HelloWorld;
import org.example.entities.Order;
import org.example.entities.Pokemon;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // we have some beans defined in our xml file, now we can access them:
        // BeanFactory is responsible for creating objects
        BeanFactory factoryXML = new ClassPathXmlApplicationContext("beans.xml");

        HelloWorld helloWorld = (HelloWorld) factoryXML.getBean("helloWorld");

        System.out.println(helloWorld.getMessage());

        Pokemon pokemon1 = (Pokemon) factoryXML.getBean("pokemon1");

        System.out.println(pokemon1);

        System.out.println("Annotation-Based Configuration:");


        // if we pass in the class to specify which bean, we don't need to cast it:
        Order order1 = factoryXML.getBean(Order.class);

        System.out.println(order1);

    }
}
