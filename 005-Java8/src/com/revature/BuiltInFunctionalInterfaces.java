package com.revature;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltInFunctionalInterfaces {

    public static void main(String[] args) {
        // Consumer - specify the type of value it's going to accept
        Consumer<String> printTwice = (value) -> {
            System.out.println(value);
            System.out.println(value);
        };

        // whenever we want to invoke the lambda expression in the consumer, we use the "accept" method
        printTwice.accept("Hello World");

        Predicate<Integer> isEven = (value) -> (value % 2 == 0);
        System.out.println(isEven.test(2));
        System.out.println(isEven.test(3));

        Function<Integer, Integer> square = (value) -> (value*value);
        System.out.println(square.apply(4));
        System.out.println(square.apply(10));

        Supplier<Integer> random = () -> {
            Random generator = new Random();
            return generator.nextInt(100);
        };

        System.out.println(random.get());



    }
}
