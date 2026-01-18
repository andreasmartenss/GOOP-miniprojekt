package org.example.SortStrategi;

import org.example.Movie;

public class SortByPrice implements SortStrategi {
    @Override
    public int compare(Movie p1, Movie p2) {
        return Integer.compare(p1.getPrice(), p2.getPrice());
    }
}
