package com.example.medicalcollege;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.teacher;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TeacherContactController implements Initializable {
    @FXML
    private VBox contactLayout;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<teacher> teachers = new ArrayList<>(teachers());
        for(int i=0; i<teachers.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("F_attendence_Item.fxml"));

            try{
                HBox hbox = fxmlLoader.load();
                TeacherContact_ItemController ci = fxmlLoader.getController();
                ci.setData(teachers.get(i));
                contactLayout.getChildren().add(hbox);
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    private List<teacher> teachers(){
        List<teacher> ls = new ArrayList<>();
        teacher teacher = new teacher();
        teacher.setName("G M Fahmi Taysir");
        teacher.setImgSrc("main/resources/com.example/image/doctor.png");
        teacher.setEmail("fahmitaysir@gmail.com");
        teacher.setPhoneNumber("01911781273");
        teacher.setDepartmant("Anatomy and Physiology");
        teacher.setSerial("01");
        ls.add(teacher);

        teacher = new teacher();
        teacher.setName("G M Fahmi Taysir");
        teacher.setImgSrc("main/resources/com.example/image/doctor.png");
        teacher.setEmail("fahmitaysir@gmail.com");
        teacher.setPhoneNumber("01911781273");
        teacher.setDepartmant("Anatomy and Physiology");
        teacher.setSerial("02");
        ls.add(teacher);

        return ls;
    }
}
