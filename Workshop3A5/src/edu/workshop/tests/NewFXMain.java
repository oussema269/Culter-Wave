package edu.workshop.tests;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class NewFXMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            // Charger la scène FXMLcategorie.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/workshop/GUI/FXMLproduit.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
