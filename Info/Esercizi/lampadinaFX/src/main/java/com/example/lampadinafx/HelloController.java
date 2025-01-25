package com.example.lampadinafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.util.ArrayList;

public class HelloController {

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

    ArrayList<Integer> rgb = new ArrayList<>(3);

    public void onBtnNewLampClick(){
        ArrayList<Integer> rgb = new ArrayList<>(3);
        rgb.add(0,0);
        rgb.add(1,0);
        rgb.add(2,0);
        try{
            Lampadina lampadina = new Lampadina(txtNameLamp.getText());
            crcLamp.setDisable(false);
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
            crcLamp.setFill(Color.rgb(rgb.get(0), rgb.get(1),rgb.get(2)));
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
            int lum = Integer.parseInt(txtLum.getText());
            Lampadina lampadina = new Lampadina(txtNameLamp.getText());
            lampadina.setLum(lum);
            crcLamp.setFill(Color.rgb(rgb.get(0),rgb.get(1),rgb.get(2),lum / 0.2));
        }catch (IllegalArgumentException | NullPointerException e){
            String s = "Luminosità non valida (tra 1 e 5)";
            setLblExc(s);
        }
    }
    public void onBtnSetRGBClick(){
        try{
            rgb.add(0,Integer.parseInt(txtR.getText()));
            rgb.add(1,Integer.parseInt(txtG.getText()));
            rgb.add(2,Integer.parseInt(txtB.getText()));
            Lampadina lampadina = new Lampadina(txtNameLamp.getText());
            lampadina.setRgb(rgb);
            crcLamp.setFill(Color.rgb(rgb.get(0), rgb.get(1),rgb.get(2)));
        }catch (IllegalArgumentException | NullPointerException e){
            String s = "Valori RGB non validi (tra 0 e 255)";
            setLblExc(s);
        }
    }

    public void onBtnTurnOnClick(){
        Lampadina lampadina = new Lampadina(txtNameLamp.getText());
        lampadina.setStatus(true);
        crcLamp.setFill(Color.rgb(lampadina.getRgb()
                .get(0), lampadina.getRgb().get(1),lampadina.getRgb().get(2)));
    }

    public void onBtnTurnOffClick(){
        Lampadina lampadina = new Lampadina(txtNameLamp.getText());
        lampadina.setStatus(false);
        crcLamp.setFill(Color.rgb(0, 0,0));
    }

}
