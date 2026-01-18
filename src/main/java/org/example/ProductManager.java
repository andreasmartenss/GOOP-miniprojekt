package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class ProductManager {

    private final ObservableList<Product> productList = FXCollections.observableArrayList();


    public ProductManager() {
        productList.addAll(
                new Product("Breaking Bad", 68,5.0, "movie"),
                new Product("Arla Skummetmælk", 10, 5.6, "groceries"),
                new Product("Aloe vera plant", 10, 5.5, "groceries")
                );
        }

    public ObservableList<Product> getProductList() {
        return productList;
    }
}

