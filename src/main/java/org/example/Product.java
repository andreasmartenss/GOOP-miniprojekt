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

    public String setName() {
        return name;
    }

    private int setPrice(int price, String valuta) throws PriceException {
            if (price < 0 ) {
               throw new PriceException("Price cannot be negative!");
            }
         return this.price = price;
    }

    private double setRating() {
        return rating;
    }

    public String getProductType(String movie, String groceries, String books) throws ProductTypeException {
        if (productType != movie || productType != groceries || productType != books) {
            throw new ProductTypeException("Product type does not exist within our categories");
        }
        return this.productType;
    }
}
