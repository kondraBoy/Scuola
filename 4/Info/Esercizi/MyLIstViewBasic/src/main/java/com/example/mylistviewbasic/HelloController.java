package com.example.mylistviewbasic;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Label lblTitle;

    @FXML
    private ListView<String> listNames;

    private String[] nomi = {"Andrea","Volodymir","Alessio","Mohamed"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listNames.getItems().addAll(nomi);
    }

    public void selectedItem(){
        String selectedName = listNames.getSelectionModel().getSelectedItem();
        if (selectedName != null) {
            lblTitle.setText("Selected: " + selectedName);
        }
    }
}






