package com.example.medicalcollege;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Notice;
import model.teacher;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class NoticeController implements Initializable {
    @FXML
    private VBox noticeLayout;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Notice> notices = new ArrayList<>(notices());
        for(int i=0; i<notices.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("NoticeItem.fxml"));

            try{
                HBox hbox = fxmlLoader.load();
                NoticeItemController ci = fxmlLoader.getController();
                ci.setData(notices.get(i));
                noticeLayout.getChildren().add(hbox);
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    String notice1 = "Due to some unavoiding condition, todays class has been prosponded. I will take the class tomorrow at 11 am";
    String notice2 = "At 8 30 am, I will be taking a class test on the topic 'Human Brain'. So, get prepared";
    private List<Notice> notices(){

        List<Notice> ls = new ArrayList<>();
        Notice notice = new Notice();
        notice.setDate("22 Oct 2023");
        notice.setTeacher("Dr. Sunni lal Molla");
        notice.setHeading("Today's Class");
        notice.setDept(notice1);
        notice.setSubject("Anatomy and Physiology");
        ls.add(notice);

        notice = new Notice();
        notice.setDate("23 Oct 2023");
        notice.setTeacher("Dr. Fahmi Ghosh");
        notice.setHeading("Class_Test");
        notice.setDept(notice2);
        notice.setSubject("Human Body");
        ls.add(notice);

        notice = new Notice();
        notice.setDate("23 Oct 2023");
        notice.setTeacher("Dr. Fahmi Ghosh");
        notice.setHeading("Class_Test");
        notice.setDept(notice2);
        notice.setSubject("Human Body");
        ls.add(notice);


        return ls;
    }
}
