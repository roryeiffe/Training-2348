package org.example.collections.comparison;

public class Movie implements Comparable{
    private String name;
    private int year;
    private double rating;

    public Movie() {

    }

    public Movie(String name, int year, double rating) {
        this.name = name;
        this.year = year;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Movie m = (Movie) o;
        // when we compare movie objects, we can leverage built-in comparison methods
        int result;
        result = this.name.compareTo(m.getName());
        // if we don't have a tie, return:
        if (result != 0) {
            return result;
        }
        // otherwise, keep going and check the other fields:
        result = this.year - m.getYear();

        // if we don't have a tie, return
        if(result != 0) {
            return result;
        }

        // manually check which rating is higher and return the corresponding integer:
        if(this.rating > m.getRating()) return 1;
        else if (this.rating < m.getRating()) return -1;
        return 0;

    }
}
