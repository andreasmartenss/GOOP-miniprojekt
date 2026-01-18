package org.example.SortStrategi;

import org.example.Movie;

public class SortByName implements SortStrategi {
    @Override
    public int compare(Movie n1, Movie n2) {
        return n1.getName().compareToIgnoreCase(n2.getName());
    }
}
