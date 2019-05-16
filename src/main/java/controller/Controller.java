package controller;

import javafx.application.Platform;
import model.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Osztály, ami kezeli a felhasználói felület komponenseinek
 * eseményeit.
 *
 */
public class Controller {

    /**
     * A Controller osztály konstruktora.
     */
    public Controller(){}

    public StringEllenorzo stringellenorzo = new StringEllenorzo();
    public String beirtszoveg;
    public String uzenet;

    @FXML
    private TextField bevitel;

    @FXML
    private Label eredmeny;


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

   @FXML
    private void kilepesGombAction(ActionEvent event){
        Platform.exit();
    }

    /**
     * A metódus meghívja a felhasználótól bekért karakterlánc
     * ellenőrzését elvégző {@code StringEllenorzo} osztály metódusát,
     * majd az eredménynek megfelelő üzenetet ír ki.
     */
    public String controll(){

        beirtszoveg = bevitel.getText();
        uzenet = stringellenorzo.stringEllenorzese(beirtszoveg);
        bevitel.setText(bevitel.getText().toUpperCase());
        eredmeny.setText(uzenet);
        return uzenet;
    }

}
