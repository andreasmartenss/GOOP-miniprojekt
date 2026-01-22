package org.example.GUI;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.transformation.FilteredList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.Movie;
import javafx.scene.control.TableView;
import org.example.MovieManager;
import org.example.MovieNotFoundException;
import org.example.SortStrategi.*;


public class GUI extends Application {


    // Declaring the strategies form the interface and the logic form the MovieManager class
    MovieManager movieManager = new MovieManager();
    SortStrategi sortByName = new SortByName();
    SortStrategi sortByPrice = new SortByPrice();
    SortStrategi sortByGenre = new SortByGenre();
    SortStrategi sortByRating = new SortByRating();

    /**
     * @param args launches the application
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * This is the GUI
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     */
    @Override
    public void start(Stage primaryStage) {

        // Border
        BorderPane root = new BorderPane();

        // Table
        TableView<Movie> movieTable = new TableView<>();

        // Search bar
        TextField searchBar = new TextField();

        // Search result
        FilteredList<Movie> filteredMovies = new FilteredList<>(movieManager.getMovieList(), m -> true);

        // The table columns that represents each of the attributes contained the Movie class
        TableColumn<Movie, String> movieName = new TableColumn<>("Name");
        movieName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Movie, Integer> moviePrice = new TableColumn<>("Price");
        moviePrice.setCellValueFactory(cellData ->
                        new SimpleIntegerProperty(
                                cellData.getValue().getPrice()
                        ).asObject()
        );

        TableColumn<Movie, Double> movieRating = new TableColumn<>("Rating");
        movieRating.setCellValueFactory(cellData ->
                        new SimpleDoubleProperty(
                                cellData.getValue().getRating()
                        ).asObject()
        );

        TableColumn<Movie, String> movieGenre = new TableColumn<>("Genre");
        movieGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));

        // Constrains the size of the table
        movieTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        // Gets the columns in the table
        movieTable.getColumns().addAll(
                movieName,
                moviePrice,
                movieRating,
                movieGenre
        );


        // Gets the objects within the movieManager that returns the ObservableList of movie objects
        movieTable.setItems(movieManager.getMovieList());
        movieTable.setItems(filteredMovies);

        // Header
        Text header = new Text("Watch List");
        header.setFont(new Font(40));

        // Button object used as an interactive button in the GUI. This is the search button
        GUIButton searchButton = new GUIButton(100, 50, 30, "Search");
        searchButton.setScaleX(0.4);
        searchButton.setScaleY(0.4);
        searchButton.setOnMousePressed(e -> {
            String search = searchBar.getText().toLowerCase().trim();
            filteredMovies.setPredicate(movie ->
                    movie.getName().toLowerCase().contains(search)
            );
        });

        // This button returns the user back to the list after searching for a specific movie
        GUIButton backToListButton = new GUIButton(100, 50, 30, "Back to list");
        backToListButton.setScaleX(0.4);
        backToListButton.setScaleY(0.4);
        backToListButton.setOnMousePressed(e -> {
            filteredMovies.setPredicate(movie ->
                    true
            );
        });

        // This button deletes the selected movie.
        GUIButton deleteButton = new GUIButton(100, 50, 30, "Delete");
        deleteButton.setScaleX(0.4);
        deleteButton.setScaleY(0.4);
        deleteButton.setOnMousePressed(e -> {
            Movie selectedMovie = movieTable.getSelectionModel().getSelectedItem();

            /*
              The try block executes the removeMovie method inside the MovieManager class.
              The catch block throws an error if the selected movie is not within movieList.
              */
            try {
                movieManager.removeMovie(selectedMovie);
            } catch (MovieNotFoundException ex) {
                System.err.println(ex.getMessage());
            }
        });

        // This button implements the sort strategi and sorts names in ascending order
        GUIButton sortByNameButton = new GUIButton(100, 50, 30, "Sort by Name");
        sortByNameButton.setScaleX(0.4);
        sortByNameButton.setScaleY(0.4);
        sortByNameButton.setOnMousePressed(e -> {
            movieManager.setSortStrategi(sortByName);
        });

        // This button implements the sort strategi and sorts prices in ascending order
        GUIButton sortByPriceButton = new GUIButton(100, 50, 30, "Sort by price");
        sortByPriceButton.setScaleX(0.4);
        sortByPriceButton.setScaleY(0.4);
        sortByPriceButton.setOnMousePressed(e -> {
            movieManager.setSortStrategi(sortByPrice);
        });


        // This button implements the sort strategi and sorts genres in ascending order
        GUIButton sortByGenreButton = new GUIButton(100, 50, 30, "Sort by genre");
        sortByGenreButton.setScaleX(0.4);
        sortByGenreButton.setScaleY(0.4);
        sortByGenreButton.setOnMousePressed(e -> {
            movieManager.setSortStrategi(sortByGenre);
        });

        // This button implements the sort strategi and sorts rating in ascending order
        GUIButton sortByRatingButton = new GUIButton(100, 50, 30, "Sort by rating");
        sortByRatingButton.setScaleX(0.4);
        sortByRatingButton.setScaleY(0.4);
        sortByRatingButton.setOnMousePressed(e -> {
            movieManager.setSortStrategi(sortByRating);
        });

        // Horizontal box that contains the search bar, the search button and the back to the list button
        HBox searchBox = new HBox(
                searchBar,
                searchButton,
                backToListButton
        );

        // Horizontal box that contains the header, the searchBox from above and the delete button
        HBox headerBox = new HBox(
                header,
                searchBox,
                deleteButton
        );

        // This box contains the individual buttons for each sorting strategi
        HBox buttonBox = new HBox(
                sortByNameButton,
                sortByPriceButton,
                sortByRatingButton,
                sortByGenreButton
        );

        // Vertical box for the movie table
        VBox tableBox = new VBox(movieTable);

        // Box that contains the previous boxed and places them vertically
        VBox box = new VBox(
                headerBox,
                tableBox,
                buttonBox
        );

        // Puts the box with the other boxes in the border pane
        root.setCenter(box);

        // Size of the scene
        Scene scene= new Scene(root, 1920, 1080);

        // Sets the scene, title and shows the scene
        primaryStage.setScene(scene);
        primaryStage.setTitle("Watch List");
        primaryStage.show();
    }

}
