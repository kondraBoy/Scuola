module com.example.mylistviewadvanced {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.mylistviewadvanced to javafx.fxml;
    exports com.example.mylistviewadvanced;
}