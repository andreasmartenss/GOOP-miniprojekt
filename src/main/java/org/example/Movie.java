package org.example;

public class Movie {

    String name;
    int price;
    double rating;
    String genre;

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

    public double setRating() {
        return rating;
    }

    public String getGenre() {
        return this.genre;
    }
}
