package com.example.medicalcollege;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("newfrontpage.fxml"));

      //  FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("information.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 950, 600);
        stage.setTitle("My College");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}