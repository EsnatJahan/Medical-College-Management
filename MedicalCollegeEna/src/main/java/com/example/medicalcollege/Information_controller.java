package com.example.medicalcollege;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class Information_controller implements Initializable {

    @FXML
    private TableView<CourseData> ctb;

    @FXML
    private TableColumn<CourseData, String> ctb_course;

    @FXML
    private TableView<EquipmentData> etb;

    @FXML
    private TableColumn<EquipmentData, String> etb_dob;

    @FXML
    private TableColumn<EquipmentData, String> etb_ed;

    @FXML
    private TableColumn<EquipmentData, String> etb_name;

    @FXML
    private TableColumn<EquipmentData, String> etb_warrenty;


    @FXML
    private TableView<HallData> htb;

    @FXML
    private TableColumn<HallData, String> htb_contacts;

    @FXML
    private TableColumn<HallData, String> htb_loc;

    @FXML
    private TableColumn<HallData, String> htb_name;

    @FXML
    private TableColumn<HallData, String> htb_rooms;

    void setup_tables() {
        ctb_course.setCellValueFactory(new PropertyValueFactory<>("Name"));

        htb_name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        htb_contacts.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        htb_rooms.setCellValueFactory(new PropertyValueFactory<>("Rooms"));
        htb_loc.setCellValueFactory(new PropertyValueFactory<>("Location"));


        etb_name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        etb_dob.setCellValueFactory(new PropertyValueFactory<>("DateOfBuy"));
        etb_ed.setCellValueFactory(new PropertyValueFactory<>("ExpiringDate"));
        etb_warrenty.setCellValueFactory(new PropertyValueFactory<>("Warrenty"));
    }

    void fill_ctb() {
        ctb.getItems().clear();
        ObservableList<CourseData> courses = ctb.getItems();
        try {
            Connection con = new DatabaseController().getConnection();
            Statement st = con.createStatement();
            PreparedStatement ps = con.prepareStatement("SELECT `Title` " +
                    "FROM `enrol` " +
                    "INNER JOIN `course` ON enrol.C_Id = course.C_Id " +
                    "WHERE `S_Id` = ? ");
            ps.setInt(1, 2004100);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("Title");
                courses.add(new CourseData(name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ctb.setItems(courses);
    }

    void fill_htb() {
        htb.getItems().clear();
        ObservableList<HallData> halls = htb.getItems();
        try {
            Connection con = new DatabaseController().getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM hall");
            while (rs.next()) {
                String name = rs.getString("Name");
                String contact = rs.getString("Contact");
                String rooms = String.valueOf(rs.getInt("Rooms"));
                String location = rs.getString("Location");
                halls.add(new HallData(name, contact, rooms, location));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        htb.setItems(halls);
    }

    void fill_etb() {
        etb.getItems().clear();
        ObservableList<EquipmentData> equipments = etb.getItems();
        try {
            Connection con = new DatabaseController().getConnection();
            Statement st = con.createStatement();
            PreparedStatement ps = con.prepareStatement("SELECT `E_Name`, Date_of_buy, Expairy_date, Warranty " +
                    "FROM `equipment` " +
                    "INNER JOIN `lab` ON equipment.L_name = lab.Name " +
                    "INNER JOIN `enrol` ON enrol.C_Id =  equipment.L_name " +
                    "WHERE `S_Id` = ? ");
            ps.setInt(1, 2004100);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("E_Name");
                String dob = rs.getDate("Date_of_buy").toString();
                String ed = rs.getString("Expairy_date");
                String warrenty = rs.getString("Warranty");
                equipments.add(new EquipmentData(name, dob, ed, warrenty));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        etb.setItems(equipments);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setup_tables();

        fill_ctb();
        fill_htb();
        fill_etb();
    }
}
