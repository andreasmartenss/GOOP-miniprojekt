package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.SortStrategi.SortStrategi;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class MovieManager {
    private Movie movie;
    private final ObservableList<Movie> movieList = FXCollections.observableArrayList();
    private SortStrategi sort;

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

    public ObservableList<Movie> getMovieList() {
        return movieList;
    }

    public void setSortStrategi(SortStrategi sortStrategi) {
        this.sort = sortStrategi;
        FXCollections.sort(movieList, sort);
    }

    public void removeMovie() throws MovieNotFoundException {
        if (!movieList.contains(movie)) {
            throw new MovieNotFoundException(" Movie not found: " + movie.getName());
        }
        movieList.remove(movie);
    }

    public List<String> searchList(String searchWords, List<String> listOfStrings) {
        List<String> searchWordArray = Arrays.asList(searchWords.trim().split(" "));

        return listOfStrings.stream().filter(input -> {
           return searchWordArray.stream().allMatch(word ->
                   input.toLowerCase().contains(word.toLowerCase()));
       }).collect(Collectors.toList());
    }
}


