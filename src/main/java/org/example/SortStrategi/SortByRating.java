package org.example.SortStrategi;

import org.example.Movie;

public class SortByRating implements SortStrategi {
    @Override
    public int compare(Movie r1, Movie r2) {
        return Double.compare(r1.getRating(), r2.getRating());
    }
}
