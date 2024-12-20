package com.example.medicalcollege;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import com.example.medicalcollege.DatabaseController;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateStudentInfoController {


    @FXML
    private TextField address;

    @FXML
    private TextField bgroup;

    @FXML
    private TextField confirmid;

    @FXML
    private PasswordField confirmpassword;
    @FXML
    private TextField currentpassword;


    @FXML
    private VBox contactLayout;

    @FXML
    private TextField image;

    @FXML
    private PasswordField password;

    @FXML
    private TextField phone;
    @FXML
    private TextField hall;


    @FXML
    void updateaccount(ActionEvent event) {
        String add= address.getText();
        String bgrp= bgroup.getText();
        String confirmass= confirmpassword.getText();
        String ctact = phone.getText();
        String currentpass=currentpassword.getText();
        String pass=password.getText();
        String cid=confirmid.getText();
        String hll=hall.getText();

        try {
            Connection databaselink = new DatabaseController().getConnection();
            String query = "select * from student where S_Id = ? and Password = ?";
            PreparedStatement pat = databaselink.prepareStatement(query);
            pat.setString(1, cid);
            pat.setString(2, currentpass);
            ResultSet rs = pat.executeQuery();
            if( rs.next())
            {
                // fill the empty add, bgrp, pass, ctact, hll with the values from the database
                if (add.isEmpty()) {
                    add = rs.getString("Address");
                }
                if (bgrp.isEmpty()) {
                    bgrp = rs.getString("B_Group");
                }
                if (pass.isEmpty()) {
                    pass = rs.getString("Password");
                }
                if (ctact.isEmpty()) {
                    ctact = rs.getString("Phone");
                }
                if (hll.isEmpty()) {
                    hll = rs.getString("H_Name");
                }
                String query_insert = "UPDATE student SET Address = ?, B_Group = ? , Password = ?, Phone = ?, H_Name=? WHERE S_Id = ?";
                pat = databaselink.prepareStatement(query_insert);

                pat.setString(1, add);

                pat.setString(2, bgrp);

                pat.setString(3,pass);

                pat.setString(4, ctact);

                pat.setString(5, hll);

                pat.setString(6, cid);
                pat.executeUpdate();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
