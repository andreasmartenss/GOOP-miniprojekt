package org.example.SortStrategi;

import org.example.Movie;

public class SortByRating implements SortStrategi {
    /**
     * This class implements the SortStrategi interface
     * @param r1 is the first movie object that contains a rating
     * @param r2 is the second movie object that contains a rating
     * @return will sort the values in ascending order
     */
    @Override
    public int compare(Movie r1, Movie r2) {
        return Double.compare(r1.getRating(), r2.getRating());
    }
}
