package org.example.SortStrategi;

import org.example.Product;

public class SortByProductType implements SortStrategi {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getProductType().compareToIgnoreCase(o2.getProductType());
    }

}
