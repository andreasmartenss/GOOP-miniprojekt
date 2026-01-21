package org.example.SortStrategi;

import org.example.Movie;

public class SortByName implements SortStrategi {
    /**
     * This class implements the SortStrategi interface
     * @param n1 is the first movie object that contains a name
     * @param n2 is the second movie object that contains a name
     * @return will sort the values in ascending order
     */
    @Override
    public int compare(Movie n1, Movie n2) {
        return n1.getName().compareToIgnoreCase(n2.getName());
    }
}
