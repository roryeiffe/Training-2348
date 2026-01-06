package com.revature.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    // simple method that takes a string and prints it ou
    public static void print(int i) {
        System.out.println("The number is : " + i);
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(7);
        numbers.add(2);
        numbers.add(5);
        numbers.add(13);
        numbers.add(20);
        numbers.add(100);
        numbers.add(-12);
        numbers.add(9);
        numbers.add(10);

        // Intermediate Operations:
        // Map - take every element in the stream and apply some operation
        // First, we need to convert the collection to a stream
        Stream<Integer> stream1 = numbers.stream();
        // terminal operation (collect) -> collect all the elements in the stream and return them in some collection:
        List<Integer> squares = stream1.map(x -> x*x).collect(Collectors.toList());
        System.out.println(squares);

        // Sorted - sort the collection:
        List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedNumbers);

        // Filter - filter based on some predicate
        List<Integer> evenNumbers = numbers.stream().filter(x -> x%2 == 0).collect(Collectors.toList());
        System.out.println(evenNumbers);

        // ForEach - instead of returning the data in a collection, we can perform some operation for each element
        numbers.stream().map(x -> x + 1).forEach(x -> System.out.println("The number is: " + x));

        // Reduce - take in a stream and reduce it to a single value:
        // reduce takes in 2 params:
            // - identity - starting value
            // - bi function - takes in 2 values (cumulative value that we are keeping track of, current value)
        int sumEven = numbers.stream().filter(x -> x%2 == 0).reduce(0, (answer, current) -> answer + current);
        System.out.println(sumEven);

        // get the number of even integers:
        int numEven = numbers.stream().filter(x -> x%2 == 0).reduce(0, (answer, current) -> answer + 1);
        System.out.println(numEven);

        // Use Method Reference:
        numbers.stream().forEach(Main::print);
    }
}
