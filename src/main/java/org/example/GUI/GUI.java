package org.example.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.Product;
import javafx.scene.control.TableView;
import org.example.ProductManager;



public class GUI extends Application {

    private final ProductManager productManager = new ProductManager();


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

        productTable.getColumns().addAll(
                productName,
                productPrice,
                productRating,
                productType
        );

        productTable.setItems(productManager.getProductList());

        Text header = new Text("Products");
        header.setFont(new Font(40));


        Button deleteButton = new Button(100, 50, 30, "Delete");
        deleteButton.setScaleX(0.4);
        deleteButton.setScaleY(0.4);


        HBox headerBox = new HBox(header, deleteButton);
        VBox tablebox = new VBox(productTable);

        VBox box = new VBox(headerBox, tablebox);

        root.setCenter(box);

        Button Deletebutton = new Button(200, 200, 40, "goddag");

        Scene scene= new Scene(root, 1920, 1080);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Product List");
        primaryStage.show();
    }

}
