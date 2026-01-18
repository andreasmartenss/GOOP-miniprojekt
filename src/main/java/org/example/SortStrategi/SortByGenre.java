package org.example.SortStrategi;

import org.example.Movie;

public class SortByGenre implements SortStrategi {
    @Override
    public int compare(Movie g1, Movie g2) {
        return g1.getGenre().compareToIgnoreCase(g2.getGenre());
    }
}
