package com.example.skladovinalichnosti;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

import static com.example.skladovinalichnosti.Login.email;

public class Sklad {


    @FXML
    private Button AddFXID;

    @FXML
    private Button BackFXID;

    @FXML
    private Button RemoveFXID;

    @FXML
    void AddOnAction(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("Dobavqne.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    @FXML
    void BackOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("NachalnoMenu.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void RemoveOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Iztrii.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
    private TableColumn<AdminView, String> Email;
    @FXML
    private TableColumn<AdminView,String> Name;

    ObservableList<AdminView> list= FXCollections.observableArrayList();


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



}
