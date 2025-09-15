package com.example.lampadinafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class HelloController {

    private Lampadina lampadina;

    @FXML
    private Button btnNewLamp;

    @FXML
    private Button btnSetLum;

    @FXML
    private Button btnSetRGB;

    @FXML
    private Button btnTurnOff;

    @FXML
    private Button btnTurnOn;

    @FXML
    private Circle crcLamp;

    @FXML
    private Label lblB;

    @FXML
    private Label lblExc;

    @FXML
    private Label lblG;

    @FXML
    private Label lblLum;

    @FXML
    private Label lblR;

    @FXML
    private Line line;

    @FXML
    private TextField txtB;

    @FXML
    private TextField txtG;

    @FXML
    private TextField txtLum;

    @FXML
    private TextField txtNameLamp;

    @FXML
    private TextField txtR;


    public void onBtnNewLampClick(){
        try{
            lampadina = new Lampadina(txtNameLamp.getText());
            lampadina.setRgb(0,0,0);
            crcLamp.setDisable(false);
            crcLamp.setVisible(true);
            txtR.setDisable(false);
            txtG.setDisable(false);
            txtB.setDisable(false);
            txtLum.setDisable(false);
            btnSetLum.setDisable(false);
            line.setDisable(false);
            btnSetRGB.setDisable(false);
            btnTurnOff.setDisable(false);
            btnTurnOn.setDisable(false);
            lblR.setDisable(false);
            lblG.setDisable(false);
            lblB.setDisable(false);
            lblLum.setDisable(false);
            crcLamp.setFill(Color.rgb(0,0 ,0));
        }catch (IllegalArgumentException | NullPointerException e){
            String s = "Nome non valido";
            setLblExc(s);
        }
    }

    public void setLblExc(String s) {
        lblExc.setText(s);
    }

    public void onBtnSetLumClick(){
        try{
            float lum = (Integer.parseInt(txtLum.getText()));
            lampadina.setLum(lum);
            crcLamp.setFill(Color.rgb(lampadina.getR(), lampadina.getG(), lampadina.getB(),(lum/5)));
        }catch (IllegalArgumentException | NullPointerException e){
            String s = "Luminosità non valida (tra 1 e 5)";
            setLblExc(s);
        }
    }

    public void setLblExcEmpty(){
        lblExc.setText("");
    }

    public void onBtnSetRGBClick(){
        try{
            lampadina.setRgb(Integer.parseInt(txtR.getText()),Integer.parseInt(txtG.getText()),Integer.parseInt(txtB.getText()));
            crcLamp.setFill(Color.rgb(lampadina.getR(), lampadina.getG(), lampadina.getB()));
        }catch (IllegalArgumentException | NullPointerException e){
            String s = "Valori RGB non validi (tra 0 e 255)";
            setLblExc(s);
        }
    }


    public void onBtnTurnOnClick(){
        lampadina.setStatus(true);
        crcLamp.setFill(Color.rgb(lampadina.getR(), lampadina.getG(), lampadina.getB()));
    }

    public void onBtnTurnOffClick(){
        Lampadina lampadina = new Lampadina(txtNameLamp.getText());
        lampadina.setStatus(false);
        crcLamp.setFill(Color.rgb(0, 0,0));
    }

    public void onBtnResetLampClick(){
        lampadina = null;
        txtR.setText("");
        txtG.setText("");
        txtB.setText("");
        txtLum.setText("");
        crcLamp.setVisible(false);
        crcLamp.setDisable(false);
        txtR.setDisable(true);
        txtG.setDisable(true);
        txtB.setDisable(true);
        txtLum.setDisable(true);
        btnSetLum.setDisable(true);
        line.setDisable(true);
        btnSetRGB.setDisable(true);
        btnTurnOff.setDisable(true);
        btnTurnOn.setDisable(true);
        lblR.setDisable(true);
        lblG.setDisable(true);
        lblB.setDisable(true);
        lblLum.setDisable(true);
        lblExc.setText("");
        txtNameLamp.setText("");
    }
}
