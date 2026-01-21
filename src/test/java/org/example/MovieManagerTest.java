package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.SortStrategi.SortByGenre;
import org.example.SortStrategi.SortByName;
import org.example.SortStrategi.SortByPrice;
import org.example.SortStrategi.SortByRating;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    /**
     * this tests if the SortByPrice strategi works
     */
    @Test
    void SortByPrice_ascending() {
        ObservableList<Movie> movies = FXCollections.observableArrayList(
                new Movie("test1", 25, 5.0, "test"),
                new Movie("test2", 23, 4.5, "test")
        );

        movies.sort(new SortByPrice());
        assertEquals(23, movies.get(0).getPrice());
        assertEquals(25, movies.get(1).getPrice());
    }

    /**
     * this tests if the SortByName strategi works
     */
    @Test
    void SortByName_ascending() {
        ObservableList<Movie> movies = FXCollections.observableArrayList(
                new Movie("B", 25, 5.0, "test"),
                new Movie("A", 23, 4.5, "test")
        );

        movies.sort(new SortByName());
        assertEquals("A", movies.get(0).getName());
        assertEquals("B", movies.get(1).getName());
    }

    /**
     * this tests if the SortByRating strategi works
     */
    @Test
    void SortByRating_ascending() {
        ObservableList<Movie> movies = FXCollections.observableArrayList(
                new Movie("B", 25, 5.0, "test"),
                new Movie("A", 23, 4.5, "test")
        );

        movies.sort(new SortByRating());
        assertEquals(4.5, movies.get(0).getRating());
        assertEquals(5.0, movies.get(1).getRating());
    }

    /**
     * this tests if the SortByGenre strategi works
     */
    @Test
    void SortByGenre_ascending() {
        ObservableList<Movie> movies = FXCollections.observableArrayList(
                new Movie("B", 25, 5.0, "Action"),
                new Movie("A", 23, 4.5, "Drama")
        );

        movies.sort(new SortByGenre());
        assertEquals("Action", movies.get(0).getGenre());
        assertEquals("Drama", movies.get(1).getGenre());
    }

    /**
     * this test throws an exception when the given movie object is not contained in an observable list.
     */
    @Test
    void removeMovie() {
        MovieManager movieManager = new MovieManager();
        Movie movie = new Movie("Test", 34, 5.0, "action");

        assertThrows(MovieNotFoundException.class, () -> {
                    movieManager.removeMovie(movie);
                });
    }
}