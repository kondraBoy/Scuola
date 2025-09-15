module com.example.mylistviewbasic {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mylistviewbasic to javafx.fxml;
    exports com.example.mylistviewbasic;
}