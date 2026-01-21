package org.example.SortStrategi;

import org.example.Movie;

public class SortByPrice implements SortStrategi {
    /**
     * This class implements the SortStrategi interface.
     * @param p1 is the first movie object that contains a price
     * @param p2 is the second movie object that contains a price
     * @return will sort the values in ascending order
     */
    @Override
    public int compare(Movie p1, Movie p2) {
        return Integer.compare(p1.getPrice(), p2.getPrice());
    }
}
