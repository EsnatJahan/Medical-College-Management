package com.example.medicalcollege;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.login;
import javax.xml.transform.Result;
import java.sql.Connection;
import com.example.medicalcollege.DatabaseController;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class showitemController {
    @FXML
    private Button addnewnotice;

    @FXML
    private TextField addnoticeabout;

    @FXML
    private TextField addnoticedate;

    @FXML
    private TextField addnoticefile;

    @FXML
    private TableView<?> addnoticetable;

    @FXML
    private TableColumn<?, ?> noticeabout;

    @FXML
    private TableColumn<?, ?> noticedate;

    @FXML
    private TableColumn<?, ?> noticefile;

    @FXML
    void Newnoticeadded(ActionEvent event) {

    }
}
