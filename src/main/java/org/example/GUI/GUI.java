package org.example.GUI;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
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
    SortStrategi sortByPrice = new SortByPrice();
    SortStrategi sortByName = new SortByName();
    SortStrategi sortByGenre = new SortByGenre();
    SortStrategi sortByRating = new SortByRating();


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();

        TableView movieTable = new TableView<Movie>();

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

       FXCollections.sort(movieManager.getProductList(), sortByName);
       FXCollections.sort(movieManager.getProductList(), sortByPrice);
       FXCollections.sort(movieManager.getProductList(), sortByGenre);
       FXCollections.sort(movieManager.getProductList(), sortByRating);

        movieTable.setItems(movieManager.getProductList());

        Text header = new Text("Watch List");
        header.setFont(new Font(40));


        Button deleteButton = new Button(100, 50, 30, "Delete");
        deleteButton.setScaleX(0.4);
        deleteButton.setScaleY(0.4);
        deleteButton.setOnMousePressed(e -> {
            movieTable.getItems().remove(0);
        });


        HBox headerBox = new HBox(header, deleteButton);
        VBox tablebox = new VBox(movieTable);

        VBox box = new VBox(headerBox, tablebox);

        root.setCenter(box);

        Scene scene= new Scene(root, 1920, 1080);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Watch List");
        primaryStage.show();
    }

}
