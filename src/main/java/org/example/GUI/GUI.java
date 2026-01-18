package org.example.GUI;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Scene {

    @Override
    public void start(Stage primaryStage) {
        primaryStageRef = primaryStage;

        primaryStage.setScene(ScannerPage.createScene());

        primaryStage.setTitle("Productlist");
        primaryStage.show();

    }

}
