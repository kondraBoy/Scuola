module com.example.lampadinafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lampadinafx to javafx.fxml;
    exports com.example.lampadinafx;
}