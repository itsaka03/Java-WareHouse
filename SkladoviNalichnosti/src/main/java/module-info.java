module com.example.skladovinalichnosti {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.skladovinalichnosti to javafx.fxml;
    exports com.example.skladovinalichnosti;
}