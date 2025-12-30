package org.example;

import java.util.Objects;

public class Movie {
    private String title;
    private String director;
    private double rating;


    public Movie(String title, String director, double rating) {
        this.title = title;
        this.director = director;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
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
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Shutting down");
        System.out.println("Could put other shut-down related logic here.");
        super.finalize();
    }

    @Override
    // Note the method declaration takes in an Object, meaning that we can pass in any type of object:
    public boolean equals(Object o) {
        // first check the reference
        // If it's the same reference, then return true immediately because we know they take up the same memory space:
        if (this == o) return true;
        // if the comparing object is null or the classes don't match up, then fail:
        if (o == null || getClass() != o.getClass()) return false;
        // cast the other object to a movie so that we can compare fields directly:
        Movie movie = (Movie) o;
        // If we sure we are comparing instances of the same class, just ensure that the fields all match up:
        return Double.compare(movie.rating, this.rating) == 0 && Objects.equals(title, movie.title) && Objects.equals(director, movie.director);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, director, rating);
    }

    public static void main(String[] args) {
        Movie movie1 = new Movie("One Battle After Another", "Paul Thomas Anderson", 5.0 );
        Movie movie2 = new Movie("One Battle After Another", "Paul Thomas Anderson", 5.0 );
        Movie movie3 = new Movie("Lord of the Rings", "Peter Jackson", 4.0 );
        Movie movie4 = new Movie("Peter Jackson","Lord of the Rings", 4.0 );

        System.out.println(movie1);
        System.out.println(movie2);

        // Check for equality:
        // should equate to false because 2 different references
        System.out.println(movie1 == movie2);
        // unless we implement the .equals method, will equate to false
        System.out.println(movie1.equals(movie2));
        System.out.println(movie3.equals(movie4)); // false

        System.out.println(movie1.hashCode());
        System.out.println(movie2.hashCode());
        System.out.println(movie3.hashCode());
        System.out.println(movie4.hashCode());

        // unreferencing the object that movie3 initially pointed to, therefore allowing movie3 to be garbage collected:
        movie3 = null;
    }
}
