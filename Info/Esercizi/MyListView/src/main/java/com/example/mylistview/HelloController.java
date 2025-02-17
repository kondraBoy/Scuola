package com.example.myli
stview;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private ListView<String> foodLstView;
    private Pane root;
    private String[] food = {"Apple", "Banana", "Cherry", "Date", "Elderberry", "Fig", "Grape", "Honeydew", "Ice Cream", "Jalapeno"};

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        foodLstView.getItems().addAll(food);
    }
}
