package com.example.skladovinalichnosti;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static com.example.skladovinalichnosti.Login.email;

public class Dobavqne {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AddFXID;

    @FXML
    private TableView<AdminView> AdminView;

    @FXML
    private Button BackFXID;

    @FXML
    private TableColumn<AdminView, String> Cena;

    @FXML
    private TextField CenaFXID;

    @FXML
    private TableColumn<AdminView, String> Data;

    @FXML
    private TableColumn<AdminView, String> Id;

    @FXML
    private TextField KolichestvoFXID;

    @FXML
    private TableColumn<AdminView, String> Kolichestvoo;

    @FXML
    private Label LabelFXID;

    @FXML
    private TableColumn<AdminView, String> Name;

    @FXML
    private TextField NameFXID;

    @FXML
    private Button View;

    @FXML
    void AddOnAction(ActionEvent event) throws SQLException {
        String nameProduct=NameFXID.getText();
        String cena=CenaFXID.getText();
        String kolichestvo=KolichestvoFXID.getText();

        if (CenaFXID.getText().matches("((-|\\\\+)?[0-9]+(\\\\.[0-9]+)?)+")&&KolichestvoFXID.getText().matches("((-|\\\\+)?[0-9]+(\\\\.[0-9]+)?)+")) {
            LocalDate data = LocalDate.now();
            ADD(nameProduct, cena, kolichestvo, data, email);
            NameFXID.setText("");
            KolichestvoFXID.setText("");
            CenaFXID.setText("");
            LabelFXID.setText("");
        }
        else
        {
            LabelFXID.setText("Попълнете правилно полетата!");
            NameFXID.setText("");
            KolichestvoFXID.setText("");
            CenaFXID.setText("");
        }

    }
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
        AdminView.setItems(list);
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
    void CenaOnAction(ActionEvent event) {

    }

    @FXML
    void KolichestvoOnAction(ActionEvent event) {

    }

    @FXML
    void NameOnaction(ActionEvent event) {

    }
    private static void ADD(String nameProduct, String cena, String kolichestvo, Object data,String email) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sklad", "root", "1234");
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO stoki (name,kolischestvo,cena,data,email) Values(?,?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, nameProduct);
            ps.setString(2, kolichestvo);
            ps.setString(3, cena);
            ps.setObject(4, data);
            ps.setString(5, email);
            ps.execute();
            System.out.println("Data has be inserted");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    @FXML
    void initialize() {
        assert AddFXID != null : "fx:id=\"AddFXID\" was not injected: check your FXML file 'Dobavqne.fxml'.";
        assert AdminView != null : "fx:id=\"AdminView\" was not injected: check your FXML file 'Dobavqne.fxml'.";
        assert BackFXID != null : "fx:id=\"BackFXID\" was not injected: check your FXML file 'Dobavqne.fxml'.";
        assert Cena != null : "fx:id=\"Cena\" was not injected: check your FXML file 'Dobavqne.fxml'.";
        assert CenaFXID != null : "fx:id=\"CenaFXID\" was not injected: check your FXML file 'Dobavqne.fxml'.";
        assert Data != null : "fx:id=\"Data\" was not injected: check your FXML file 'Dobavqne.fxml'.";
        assert Id != null : "fx:id=\"Id\" was not injected: check your FXML file 'Dobavqne.fxml'.";
        assert KolichestvoFXID != null : "fx:id=\"KolichestvoFXID\" was not injected: check your FXML file 'Dobavqne.fxml'.";
        assert Kolichestvoo != null : "fx:id=\"Kolichestvoo\" was not injected: check your FXML file 'Dobavqne.fxml'.";
        assert LabelFXID != null : "fx:id=\"LabelFXID\" was not injected: check your FXML file 'Dobavqne.fxml'.";
        assert Name != null : "fx:id=\"Name\" was not injected: check your FXML file 'Dobavqne.fxml'.";
        assert NameFXID != null : "fx:id=\"NameFXID\" was not injected: check your FXML file 'Dobavqne.fxml'.";
        assert View != null : "fx:id=\"View\" was not injected: check your FXML file 'Dobavqne.fxml'.";

    }

}
