package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class MovieManager {

    private final ObservableList<Movie> movieList = FXCollections.observableArrayList();
    
    public MovieManager() {
        movieList.addAll(
                new Movie("Scarface", 68,5.0, "action"),
                new Movie("The Godfather", 75, 4.9, "crime"),
                new Movie("The Dark Knight", 80, 4.8, "action"),
                new Movie("Pulp Fiction", 70, 4.7, "crime"),
                new Movie("Fight Club", 65, 4.6, "drama"),
                new Movie("Inception", 78, 4.7, "sci-fi"),
                new Movie("The Matrix", 60, 4.6, "sci-fi"),
                new Movie("Goodfellas", -1, 4.8, "crime"),
                new Movie("Interstellar", 85, 4.7, "sci-fi"),
                new Movie("Gladiator", 68, 4.5, "action"),
                new Movie("The Shawshank Redemption", 90, 5.0, "drama"),
                new Movie("Forrest Gump", 66, 4.6, "drama"),
                new Movie("The Silence of the Lambs", 62, 4.5, "thriller"),
                new Movie("Se7en", 64, 4.6, "thriller"),
                new Movie("The Departed", 70, 4.4, "crime"),
                new Movie("Whiplash", 55, 4.7, "drama"),
                new Movie("Parasite", 58, 4.6, "thriller"),
                new Movie("Joker", 69, 4.3, "drama"),
                new Movie("Django Unchained", 73, 4.5, "western"),
                new Movie("The Wolf of Wall Street", 77, 4.4, "biography"),
                new Movie("No Country for Old Men", 61, 4.5, "thriller")
                );
        }

    public ObservableList<Movie> getProductList() {
        return movieList;
    }

    private void setPrice(Movie movie) {
        try {
            if (movie.getPrice() < 0 ) {
                System.err.println("Prices must");
            }
        } catch (PriceException e) {
            System.err.println("error");
        }

    }
}


