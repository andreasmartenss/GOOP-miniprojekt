package org.example.SortStrategi;

import org.example.Product;

public class SortByPrice implements SortStrategi {
    @Override
    public int compare(Product p1, Product p2) {
        return Integer.compare(p1.getPrice(), p2.getPrice());
    }
}
