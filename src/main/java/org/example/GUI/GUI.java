package org.example.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.example.Product;
import javafx.scene.control.TableView;


public class GUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();

        TableView productTable = new TableView<Product>();

        TableColumn productName = new TableColumn<Product, String>("Name");
        productName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));

        TableColumn productPrice = new TableColumn<Product, Integer>("Price");
        productPrice.setCellValueFactory(new PropertyValueFactory<Product, Integer>("price"));

        TableColumn productRating = new TableColumn<Product, Double>("Rating");
        productRating.setCellValueFactory(new PropertyValueFactory<Product, Double>("rating"));

        TableColumn productType = new TableColumn<Product, String>("Type");
        productType.setCellValueFactory(new PropertyValueFactory<Product, String>("productType"));

        productTable.getColumns().add(productName);
        productTable.getColumns().add(productPrice);
        productTable.getColumns().add(productRating);
        productTable.getColumns().add(productType);

        root.setCenter(productTable);

        Button button = new Button(200, 200, 40, "goddag");

        Scene scene= new Scene(root, 1920, 1080);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Product List");
        primaryStage.show();
    }

}
