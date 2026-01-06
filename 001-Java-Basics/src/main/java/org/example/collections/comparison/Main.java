package org.example.collections.comparison;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Star Wars", 1977, 9.0));
        movies.add(new Movie("Star Wars", 1980, 8.0));
        movies.add(new Movie("Star Wars", 1982, 6.0));
        movies.add(new Movie("Star Wars", 1960, 6.0));
        movies.add(new Movie("Harry Potter", 2001, 7.0));
        movies.add(new Movie("Harry Potter", 2001, 7.2));
        movies.add(new Movie("Harry Potter", 2001, 6.2));
        movies.add(new Movie("Harry Potter", 2001, 1.2));

        System.out.println(movies);

        System.out.println(movies.stream().sorted().collect(Collectors.toList()));

        Collections.sort(movies, new MovieYearComparator());

        System.out.println(movies);
    }
}
