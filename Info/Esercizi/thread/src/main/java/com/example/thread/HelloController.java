package com.example.thread;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Button btnDeposito;

    @FXML
    private Button btnPrelievo;

    @FXML
    private Label lblOpe;

    @FXML
    private Label lblSaldo;

    @FXML
    private TextField txtSoldi;

    Cassaforte cassaforte;

    Operazioni operazione;

    public HelloController() {
        cassaforte = new Cassaforte(0, 1000);
    }


    public void onBtnDepositoClick() {
        double soldi = Double.parseDouble(txtSoldi.getText());
        operazione = new Operazioni(true, soldi, cassaforte,HelloController.this);
        //operazione.setUncaughtExceptionHandler((t, e) -> {
            javafx.application.Platform.runLater(() -> {
                lblOpe.setText("Deposito non effettuato");
            });
       // });
        operazione.start();
    }

    public void onBtnPrelievoClick() {
        double soldi = Double.parseDouble(txtSoldi.getText());
        operazione = new Operazioni(false, soldi, cassaforte,HelloController.this);
        operazione.setUncaughtExceptionHandler((t, e) -> {
            Platform.runLater(() -> {
                lblOpe.setText("Prelievo non effettuato");
            });
        });
        operazione.start();
    }

    public void update(boolean operazione, double soldi, double saldo){
        javafx.application.Platform.runLater(() -> {
            lblSaldo.setText("Saldo: " + saldo);
            if(operazione){
                lblOpe.setText("Deposito di " + soldi + " effettuato");
            }else{
                lblOpe.setText("Prelievo di " + soldi + " effettuato");
            }
        });

    }

    public void setLblSaldo(){
        lblSaldo.setText(String.valueOf(cassaforte.getSaldo()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblSaldo.setText(String.valueOf(cassaforte.getSaldo()));
    }
}



