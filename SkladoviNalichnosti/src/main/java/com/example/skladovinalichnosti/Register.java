package com.example.skladovinalichnosti;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register {

    @FXML
    private TextField EmailFXID;

    @FXML
    private Button LoginFXID;

    @FXML
    private Label LabelFXID;

    @FXML
    private TextField NameFXID;

    @FXML
    private PasswordField PassFXID;

    @FXML
    private TextField PhoneFXID;

    @FXML
    private Button RegisterFXID;

    @FXML
    void EmailOnAction(ActionEvent event) {

    }

    @FXML
    void LoginOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void NameOnAction(ActionEvent event) {

    }

    @FXML
    void PassOnAction(ActionEvent event) {

    }

    @FXML
    void PhoneOnAction(ActionEvent event) {

    }

    @FXML
    void RegisterOnAction(ActionEvent event) throws SQLException, IOException {

            String name = NameFXID.getText();
            String email = EmailFXID.getText();
            String password = PassFXID.getText();
            String phone = PhoneFXID.getText();
        if(name ==""|| email=="" || password=="" || phone=="") {
            LabelFXID.setText("Въведете правилно полетата!");
        }else {
            Registration(name, email, password, phone);
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
    }

    private void Registration(String name, String email, String password, String phone) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sklad", "root", "1234");
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO profile (name,email,password,phone) Values(?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, phone);
            ps.execute();
            System.out.println("Data has be inserted");


        } catch (SQLException e) {
            System.out.println(e.toString());

        }




    }
}