module com.example.mylistview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mylistview to javafx.fxml;
    exports com.example.mylistview;
}