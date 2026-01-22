package org.example.SortStrategi;

import org.example.Movie;

public class SortByGenre implements SortStrategi {

    /**
     * This class implements the SortStrategi interface
     * @param g1 is the first movie object that contains a genre
     * @param g2 is the second movie object that contains a genre
     * @return will sort the values in alphabetical order.
     */
    @Override
    public int compare(Movie g1, Movie g2) {
        return g1.getGenre().compareToIgnoreCase(g2.getGenre());
    }
}
