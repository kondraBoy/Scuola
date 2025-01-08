module com.example.provaui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.provaui to javafx.fxml;
    exports com.example.provaui;
}