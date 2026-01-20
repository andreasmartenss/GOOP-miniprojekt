package org.example.GUI;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
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
import org.example.SortStrategi.*;


public class GUI extends Application {

    private final MovieManager movieManager = new MovieManager();
    SortStrategi sortByName = new SortByName();
    SortStrategi sortByPrice = new SortByPrice();
    SortStrategi sortByGenre = new SortByGenre();
    SortStrategi sortByRating = new SortByRating();




    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();

        TableView<Movie> movieTable = new TableView<>();
        TextField searchBar = new TextField();


        TableColumn movieName = new TableColumn<Movie, String>("Name");
        movieName.setCellValueFactory(new PropertyValueFactory<Movie, String>("name"));

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


        TableColumn movieGenre = new TableColumn<Movie, String>("Genre");
        movieGenre.setCellValueFactory(new PropertyValueFactory<Movie, String>("genre"));

        movieTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        movieTable.getColumns().addAll(
                movieName,
                moviePrice,
                movieRating,
                movieGenre
        );


        movieTable.setItems(movieManager.getMovieList());

        Text header = new Text("Watch List");
        header.setFont(new Font(40));

        Button searchbutton = new Button(100, 50, 30, "Search");
        searchbutton.setScaleX(0.4);
        searchbutton.setScaleY(0.4);
        searchbutton.setOnMousePressed(e -> {
            movieTable.getItems().clear();
            movieTable.getItems().addAll(movieManager.searchList(searchBar.getText(), //et eller andet her));
        });

        Button deleteButton = new Button(100, 50, 30, "Delete");
        deleteButton.setScaleX(0.4);
        deleteButton.setScaleY(0.4);
        deleteButton.setOnMousePressed(e -> {
            Movie selectedMovie = movieTable.getSelectionModel().getSelectedItem();
            movieTable.getItems().remove(selectedMovie);
        });

        Button sortByNameButton = new Button(100, 50, 30, "Sort by Name");
        sortByNameButton.setScaleX(0.4);
        sortByNameButton.setScaleY(0.4);
        sortByNameButton.setOnMousePressed(e -> {
            movieManager.setSortStrategi(sortByName);
        });

        Button sortByPriceButton = new Button(100, 50, 30, "Sort by price");
        sortByPriceButton.setScaleX(0.4);
        sortByPriceButton.setScaleY(0.4);
        sortByPriceButton.setOnMousePressed(e -> {
            movieManager.setSortStrategi(sortByPrice);
        });


        Button sortByGenreButton = new Button(100, 50, 30, "Sort by genre");
        sortByGenreButton.setScaleX(0.4);
        sortByGenreButton.setScaleY(0.4);
        sortByGenreButton.setOnMousePressed(e -> {
            movieManager.setSortStrategi(sortByGenre);
        });

        Button sortByRatingButton = new Button(100, 50, 30, "Sort by rating");
        sortByRatingButton.setScaleX(0.4);
        sortByRatingButton.setScaleY(0.4);
        sortByRatingButton.setOnMousePressed(e -> {
            movieManager.setSortStrategi(sortByRating);
        });

        HBox searchbox = new HBox(searchBar, searchbutton);

        HBox headerBox = new HBox(
                header,
                searchbox,
                deleteButton
        );

        HBox buttonBox = new HBox(
                sortByNameButton,
                sortByPriceButton,
                sortByRatingButton,
                sortByGenreButton)
                ;

        VBox tablebox = new VBox(movieTable);

        VBox box = new VBox(headerBox, tablebox, buttonBox);

        root.setCenter(box);

        Scene scene= new Scene(root, 1920, 1080);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Watch List");
        primaryStage.show();
    }

}
