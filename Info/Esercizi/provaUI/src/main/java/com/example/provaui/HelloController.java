package com.example.provaui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Button btnMsgCiao;

    @FXML
    private Label lblMsg;

    public void onbtnMsgCiaoClick(){
        lblMsg.setText("Benvenuti nell'applicazione")
    }
}