package com.example.medicalcollege;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.Notice;
import model.teacher;

import java.net.URL;
import java.util.ResourceBundle;

public class NoticeItemController implements Initializable {

    @FXML
    private Label dept;

    @FXML
    private Label date;

    @FXML
    private Label heading;

    @FXML
    private Label subject;

    @FXML
    private Label teacher;

    @FXML
    private Label srl;

    public void setData(Notice notice){
//       Image imgProfile = new Image(getClass().getResourceAsStream(teacher.getImgSrc()));
//        img.setImage(imgProfile);

        date.setText(notice.getDate());
        heading.setText(notice.getHeading());
        subject.setText(notice.getSubject());
        teacher.setText(notice.getTeacher());
        dept.setText(notice.getDept());
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}

