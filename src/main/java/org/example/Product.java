package org.example;

public class Product {

    String name;
    int price;
    double rating;
    String productType;

    public Product(String n, int p, double r, String t) {
        this.name = n;
        this.price = p;
        this.rating = r;
        this.productType = t;
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

    public String getProductType() {
        return this.productType;
    }

    private int setPrice(int price) throws PriceException {
        if (price < 0 ) {
            throw new PriceException("Price cannot be negative!");
        }
        return this.price = price;
    }
}
