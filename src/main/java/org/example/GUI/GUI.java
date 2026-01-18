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
import org.example.Product;
import javafx.scene.control.TableView;
import org.example.ProductManager;
import org.example.SortStrategi.SortByPrice;
import org.example.SortStrategi.SortStrategi;


public class GUI extends Application {

    private final ProductManager productManager = new ProductManager();
    SortStrategi sortByPrice = new SortByPrice();


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();

        TableView productTable = new TableView<Product>();

        TableColumn productName = new TableColumn<Product, String>("Name");
        productName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));

        TableColumn<Product, Integer> productPrice = new TableColumn<>("Price");
        productPrice.setCellValueFactory(cellData ->
                        new SimpleIntegerProperty(
                                cellData.getValue().getPrice()
                        ).asObject()
        );

        TableColumn<Product, Double> productRating = new TableColumn<>("Rating");
        productRating.setCellValueFactory(cellData ->
                        new SimpleDoubleProperty(
                                cellData.getValue().getRating()
                        ).asObject()
        );


        TableColumn productType = new TableColumn<Product, String>("Type");
        productType.setCellValueFactory(new PropertyValueFactory<Product, String>("productType"));

        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        productTable.getColumns().addAll(
                productName,
                productPrice,
                productRating,
                productType
        );

        FXCollections.sort(productManager.getProductList(), sortByPrice);

        productTable.setItems(productManager.getProductList());

        Text header = new Text("Products");
        header.setFont(new Font(40));


        Button deleteButton = new Button(100, 50, 30, "Delete");
        deleteButton.setScaleX(0.4);
        deleteButton.setScaleY(0.4);
        deleteButton.setOnMousePressed(e -> {
            productTable.getItems().remove(0);
        });


        HBox headerBox = new HBox(header, deleteButton);
        VBox tablebox = new VBox(productTable);

        VBox box = new VBox(headerBox, tablebox);

        root.setCenter(box);

        Scene scene= new Scene(root, 1920, 1080);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Product List");
        primaryStage.show();
    }

}
