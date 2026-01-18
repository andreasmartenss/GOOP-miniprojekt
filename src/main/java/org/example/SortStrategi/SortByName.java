package org.example.SortStrategi;

import org.example.Product;

public class SortByName implements SortStrategi {
    @Override
    public int compare(Product n1, Product n2) {
        return n1.getName().compareToIgnoreCase(n2.getName());
    }
}
