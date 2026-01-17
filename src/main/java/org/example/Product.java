package org.example;

public class Product {

    String name;
    int price;
    double rating;

    public Product(String n, int p, double r) {
        this.name = n;
        this.price = p;
        this.rating = r;
    }

    public String setName() {
        return name;
    }

    private int setPrice() {
        return price;
    }

    private double setRating() {
        return rating;
    }
}
