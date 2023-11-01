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

public class AdminCheck {

    @FXML
    private Button BackFXID;

    @FXML
    private Button ContinueFXID;

    @FXML
    private TextField NameFXID;

    @FXML
    private PasswordField PassFXID;
    @FXML
    private Label LabelFXID;

    @FXML
    void BackOnAction(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("NachalnoMenu.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }


    @FXML
    void ContinueOnAction(ActionEvent event) throws IOException {
        if(NameFXID.getText().equals("admin")&&PassFXID.getText().equals("12345")){
            Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else
            NameFXID.setText("");
            PassFXID.setText("");
            LabelFXID.setText("Грешно име или парола!");
    }

    @FXML
    void NameOnAction(ActionEvent event) {

    }

    @FXML
    void PassOnAction(ActionEvent event) {

    }

}
