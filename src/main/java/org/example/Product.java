package org.example;

public class Product {

    String name;
    int price;
    double rating;
    String type;

    public Product(String n, int p, double r, String t) {
        this.name = n;
        this.price = p;
        this.rating = r;
        this.type = t;
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

    public String getProductType() {
        return type;
    }
}
