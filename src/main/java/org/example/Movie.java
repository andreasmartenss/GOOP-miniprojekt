package org.example;

public class Movie {

    String name;
    int price;
    double rating;
    String genre;

    /**
     * This is the class for the movie object
     * @param n is the parameter that equals to the name attribute
     * @param p is the parameter that equals to the price attribute
     * @param r is the parameter that
     * @param g
     */
    public Movie(String n, int p, double r, String g) {
        this.name = n;
        this.price = p;
        this.rating = r;
        this.genre = g;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public String getGenre() {
        return this.genre;
    }
}
