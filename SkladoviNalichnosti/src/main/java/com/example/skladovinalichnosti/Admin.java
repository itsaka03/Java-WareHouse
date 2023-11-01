package com.example.skladovinalichnosti;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

public class Admin {
    @FXML
    private TextField IdFXID;

    @FXML
    private Label LabelFXID;

    @FXML
    private Button BackFXID;

    @FXML
    private Button EditFXID;

    @FXML
    private TextField KolichestvoFXID;

    @FXML
    private TextField NameFXID;
    @FXML
    private TextField CenaFXID;
    @FXML
    private Button View;
    @FXML
    void BackOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("NachalnoMenu.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void ClearOnAction(ActionEvent event) {
NameFXID.clear();
IdFXID.clear();
KolichestvoFXID.clear();
    }

    @FXML
    void EditOnAction(ActionEvent event) {
        if (CenaFXID.getText().matches("((-|\\\\+)?[0-9]+(\\\\.[0-9]+)?)+")&&KolichestvoFXID.getText().matches("((-|\\\\+)?[0-9]+(\\\\.[0-9]+)?)+")) {
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sklad", "root", "1234");
                String kolichestvo = KolichestvoFXID.getText();
                String name = NameFXID.getText();
                String id = IdFXID.getText();
                String cena = CenaFXID.getText();
                String sql = "update stoki set name= '" + name + "',kolischestvo= '" + kolichestvo + "',cena= '" + cena + "' where id='" + id + "'";
                ps = con.prepareStatement(sql);
                ps.execute();
                System.out.println("Table is edit");
                NameFXID.clear();
                IdFXID.clear();
                KolichestvoFXID.clear();
                CenaFXID.clear();
                LabelFXID.setText("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            LabelFXID.setText("Въведете правилно полетата");
            NameFXID.clear();
            IdFXID.clear();
            KolichestvoFXID.clear();
            CenaFXID.clear();

        }
    }

    @FXML
    void KolichestvoOnAction(ActionEvent event) {

    }

    @FXML
    void NameOnAction(ActionEvent event) {

    }
    @FXML
    void EmailOnAction(ActionEvent event) {

    }

    @FXML
    void CenaOnAction(ActionEvent event) {

    }


    @FXML
    private TableView<AdminView> AdminView;
    @FXML
    private TableColumn<AdminView,String> Cena;
    @FXML
    private TableColumn<AdminView,String> Data;
    @FXML
    private TableColumn<AdminView,String> Id;
    @FXML
    private TableColumn<AdminView,String> Kolichestvoo;

    @FXML
    private TableColumn<AdminView,String> Name;
    @FXML
    private TableColumn<AdminView, String> Email;
    @FXML
    private TextField EmailFXID;

    ObservableList<AdminView> list= FXCollections.observableArrayList();
    @FXML
    void IdONACTION(ActionEvent event) {

    }

    @FXML
    void ViewOnAction(ActionEvent event) {
        PreparedStatement ps = null;
        ResultSet rs=null;
        try {
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sklad", "root", "1234");
            String sql = "Select * from stoki ";
            ps = con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                list.add(new AdminView(rs.getString("id"),rs.getString("name"),rs.getString("kolischestvo"),rs.getString("cena"),rs.getString("data"),rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Id.setCellValueFactory(new PropertyValueFactory<>("id"));
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Kolichestvoo.setCellValueFactory(new PropertyValueFactory<>("kolichestvoo"));
        Cena.setCellValueFactory(new PropertyValueFactory<>("cena"));
        Data.setCellValueFactory(new PropertyValueFactory<>("data"));
        Email.setCellValueFactory(new PropertyValueFactory<>("email"));
        AdminView.setItems(list);
    }

    @FXML
    void initialize() {
        assert AdminView != null : "fx:id=\"AdminView\" was not injected: check your FXML file 'Admin.fxml'.";
        assert BackFXID != null : "fx:id=\"BackFXID\" was not injected: check your FXML file 'Admin.fxml'.";
        assert Cena != null : "fx:id=\"Cena\" was not injected: check your FXML file 'Admin.fxml'.";

        assert Data != null : "fx:id=\"Data\" was not injected: check your FXML file 'Admin.fxml'.";
        assert EditFXID != null : "fx:id=\"EditFXID\" was not injected: check your FXML file 'Admin.fxml'.";
        assert Id != null : "fx:id=\"Id\" was not injected: check your FXML file 'Admin.fxml'.";
        assert IdFXID != null : "fx:id=\"IdFXID\" was not injected: check your FXML file 'Admin.fxml'.";
        assert Kolichestvoo != null : "fx:id=\"Kolichestvo\" was not injected: check your FXML file 'Admin.fxml'.";
        assert KolichestvoFXID != null : "fx:id=\"KolichestvoFXID\" was not injected: check your FXML file 'Admin.fxml'.";
        assert Name != null : "fx:id=\"Name\" was not injected: check your FXML file 'Admin.fxml'.";
        assert NameFXID != null : "fx:id=\"NameFXID\" was not injected: check your FXML file 'Admin.fxml'.";
        assert View != null : "fx:id=\"View\" was not injected: check your FXML file 'Admin.fxml'.";
    }
}
/*
  PreparedStatement ps = null;
        ResultSet rs=null;
        try{

            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sklad", "root", "1234");

            String kolichestvo=KolichestvoFXID.getText();
            String name= NameFXID.getText();
            String id=IdFXID.getText();
            String sql="update addbook set name= '"+ NameFXID+"',kolischestvo= '"+KolichestvoFXID+"' where id='"+IdFXID+"'";
            ps=con.prepareStatement(sql);
            ps.execute();
            System.out.println("Table is edit");
        }catch (Exception e){
            e.printStackTrace();
        }
 */