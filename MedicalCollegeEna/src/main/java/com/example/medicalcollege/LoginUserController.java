package com.example.medicalcollege;


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


public class LoginUserController {
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;

    public String pss;

    @FXML
    private TextField usernamefield;
    private Parent root;
    @FXML
    private PasswordField userpasswordfield;


    @FXML
    void LoginToUser(ActionEvent event) throws IOException {
        if(usernamefield.getText().isBlank()==true)
        {
            usernamefield.setText("Please Give the Username!");
        }else if(userpasswordfield.getText().isBlank()==true)
        {
            userpasswordfield.setText("Please Give the Password!");
        }else {
            String name = usernamefield.getText();
            String pss = new String(userpasswordfield.getText());
            try {
                Connection databaselink = new DatabaseController().getConnection();
                String query = "select * from student where S_Name = ? and Password = ?";
                PreparedStatement pat = databaselink.prepareStatement(query);
                pat.setString(1, name);
                pat.setString(2, pss);
                ResultSet rs = pat.executeQuery();
                if(rs.next())
                {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
                    root = loader.load();
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                    HelloController helloController = loader.getController();
                    helloController.displayName(name);
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.centerOnScreen();
                    stage.show();

                    System.out.println(name);
                    System.out.println(pss);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
