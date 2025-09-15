package com.example.provaui;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextField;
        import javafx.scene.input.KeyEvent;

public class HelloController {

    @FXML
    private Button btnAdd;

    @FXML
    private Label lblExc;

    @FXML
    private TextField txtNmb1;

    @FXML
    private TextField txtNmb2;

    @FXML
    private TextField txtNmbResult;

    @FXML
    void onbtnAddClick(ActionEvent event) {
        int n1=0, n2=0, somma;
        try{
            n1=Integer.parseInt(this.txtNmb1.getText());
            n2=Integer.parseInt(this.txtNmb2.getText());
        }
        catch (NumberFormatException e){
            lblExc.setText("ERRORE: NON SONO STATI INSERITI DEI NUMERI");
        }
        somma=n1+n2;
        this.txtNmbResult.setText(String.valueOf(somma));
    }

    @FXML
    void removeErrors(KeyEvent event) {
        this.lblExc.setText(" ");
    }

}


