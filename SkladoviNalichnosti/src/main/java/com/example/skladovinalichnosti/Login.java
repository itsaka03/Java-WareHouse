package com.example.skladovinalichnosti;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
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

public class Login {

    @FXML
    private TextField ImailFXID;

    @FXML
    private Label LabelFXID;

    @FXML
    private Button LoginFXID;

    @FXML
    private PasswordField PassFXID;

    @FXML
    private Button RegisterFXID;

    @FXML
    void ImailOnAction(ActionEvent event) {

    }
    public static String email = "";
    @FXML
    void LoginOnAction(ActionEvent event) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sklad", "root", "1234");
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (ImailFXID.getText() != "" && PassFXID.getText() != "") {
            try {
                String sql = "Select * from profile Where email=? and password=? ";
                ps = connection.prepareStatement(sql);
                ps.setString(1, ImailFXID.getText());
                ps.setString(2, PassFXID.getText());
                rs = ps.executeQuery();

                if (rs.next()) {
                    System.out.println("Login is sucesfull");
                    email = ImailFXID.getText();
                    Parent root = FXMLLoader.load(getClass().getResource("NachalnoMenu.fxml"));
                    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                } else {
                    ImailFXID.setText("");
                    PassFXID.setText("");
                    LabelFXID.setText("Грешно име или парола!");
                }

            } catch (Exception e) {
                System.out.println(e.toString());
                System.out.println("error");
            }
        } else {
            ImailFXID.setText("");
            PassFXID.setText("");
            LabelFXID.setText("Грешно име или парола!");
        }

    }

    @FXML
    void PassOnAction(ActionEvent event) {

    }

    @FXML
    void RegisterOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
