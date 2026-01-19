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

    public int getPrice() throws PriceException {
         return price;
    }

    public double getRating() {
        return rating;
    }

    public String getGenre() {
        return this.genre;
    }

    private int setPrice(int price) {
        try {
            if (price < 0 ) {
                System.err.println("prices cannot be below 0");
            }
        } catch (PriceException e) {

        }

        return this.price = price;
    }
}
