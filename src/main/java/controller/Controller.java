package controller;

import model.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    public Controller(){}

    public StringEllenorzo stringellenorzo = new StringEllenorzo();
    public String beirtszoveg;
    public String uzenet;

    @FXML
    private TextField bevitel;

    @FXML
    private Button ellenorzogomb;

    @FXML
    private Label eredmeny;

    @FXML
    private Button torles;

    @FXML
    private Button kilepes;

    @FXML
    public void initialize() { }

    @FXML
    private void ellenorzoGombAction(ActionEvent event){
        controll();
    }

    @FXML
    private void torlesGombAction(ActionEvent event){
        bevitel.clear();
    }


    public String controll(){

        beirtszoveg = bevitel.getText();
        uzenet = stringellenorzo.stringEllenorzese(beirtszoveg);
        bevitel.setText(bevitel.getText().toUpperCase());
        eredmeny.setText(uzenet);
        return uzenet;
    }

}
