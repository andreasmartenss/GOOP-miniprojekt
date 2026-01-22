package org.example;

public class Movie {

    private final String name;
    private int price;
    private double rating;
    private final String genre;

    /**
     * This is the constructor for the movie class
     * @param n is the parameter that equals to the name attribute
     * @param p is the parameter that equals to the price attribute
     * @param r is the parameter that equals to the rating attribute
     * @param g is the parameter the equals to the genre attribute
     */
    public Movie(String n, int p, double r, String g) {
        this.name = n;
        this.price = p;
        this.rating = r;
        this.genre = g;
    }

    /**
     * @return the name of the movie object
     */
    public String getName() {
        return name;
    }

    /**
     * @return the price of the movie object
     */
    public int getPrice() {
        return price;
    }

    /**
     * @return the rating of the movie object
     */
    public double getRating() {
        return rating;
    }

    /**
     * @return the genre of the movie object
     */
    public String getGenre() {
        return this.genre;
    }
}
