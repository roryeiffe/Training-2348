package org.example.collections.comparison;

import java.util.Comparator;

// Just order by year, don't care about the other fields:
public class MovieYearComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getYear() - o2.getYear();
    }
}
