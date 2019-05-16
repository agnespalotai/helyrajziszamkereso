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

    /**
     * Példányosít egy {@code StringEllenorzo} osztályt.
     */
    public StringEllenorzo stringellenorzo = new StringEllenorzo();

    /**
     * A felhasználó által beírt karakterláncot tároló tag.
     */
    public String beirtszoveg;

    /**
     * A beírt karakterlánc ellenőrzés eredményének megfelelő üzenet.
     */
    public String uzenet;

    /**
     * A felhasználói felület beviteli mezője.
     */
    @FXML
    private TextField bevitel;

    /**
     * A felhasználói felület eredmény mezője.
     */
    @FXML
    private Label eredmeny;

    /**
     * A metódus inicializálja a felhasználói felületet.
     */
    @FXML
    public void initialize() { }

    /**
     * A felhasználói felület ellenőrző gombjának eseménykezelő metódusa.
     * @param event az esemény
     */
    @FXML
    private void ellenorzoGombAction(ActionEvent event){
        controll();
    }

    /**
     * A felhasználói felület törlés gombjának eseménykezelő metódusa.
     * @param event az esemény
     */
    @FXML
    private void torlesGombAction(ActionEvent event){
        bevitel.clear();
    }

    /**
     * A felhasználói felület kilépés gombjának eseménykezelő metódusa.
     * @param event az esemény
     */
   @FXML
    private void kilepesGombAction(ActionEvent event){
        Platform.exit();
    }

    /**
     * A metódus meghívja a felhasználótól bekért karakterlánc
     * ellenőrzését elvégző {@code StringEllenorzo} osztály metódusát,
     * majd az eredménynek megfelelő üzenetet ír ki.
     * @return az üzenet szövege
     */
    public String controll(){

        beirtszoveg = bevitel.getText();
        uzenet = stringellenorzo.stringEllenorzese(beirtszoveg);
        bevitel.setText(bevitel.getText().toUpperCase());
        eredmeny.setText(uzenet);
        return uzenet;
    }

}
