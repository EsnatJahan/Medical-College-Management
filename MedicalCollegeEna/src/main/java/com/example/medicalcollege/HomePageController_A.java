package com.example.medicalcollege;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController_A {
    @FXML
    private BorderPane borderpane;

    @FXML
    private VBox faculty;

    @FXML
    private VBox gallery;

    @FXML
    private VBox notice;

    @FXML
    private VBox study;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;


    @FXML
    void addOtherInfo(MouseEvent event) throws IOException {
        ScrollPane pane = FXMLLoader.load(getClass().getResource("A_addOtherInfo.fxml"));
        borderpane.setCenter(pane);
    }
    @FXML
    void addFaculty(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("A_addFaculty.fxml"));
        borderpane.setCenter(pane);
    }

    @FXML
    void addNotice(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("A_addNotice.fxml"));
        borderpane.setCenter(pane);
    }

    @FXML
    void addStudent(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("A_addStudent.fxml"));
        borderpane.setCenter(pane);
    }
    @FXML
    void MoveToHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("newfrontpage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
