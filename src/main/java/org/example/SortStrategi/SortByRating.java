package org.example.SortStrategi;

import org.example.Product;

public class SortByRating implements SortStrategi {
    @Override
    public int compare(Product r1, Product r2) {
        return Double.compare(r1.getRating(), r2.getRating());
    }
}
