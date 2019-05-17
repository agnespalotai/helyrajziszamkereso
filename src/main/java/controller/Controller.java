package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;
import model.*;


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
     * A felhasználói felület inicializáló metódusa.
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
        eredmeny.setText("");
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
     */
    public void controll(){

        beirtszoveg = bevitel.getText();
        uzenet = stringellenorzo.stringEllenorzese(beirtszoveg);
        bevitel.setText(bevitel.getText().toUpperCase());
        eredmeny.setText(uzenet);
        if(!uzenet.equals("OK")){
            eredmeny.setText(uzenet);
            return;
        }

    eredmeny.setText("");

    Kereses kereses = new Kereses();

    List<Hrsz> hrsz = kereses.readHrszBy(beirtszoveg);

    StringBuilder uzi = new StringBuilder();

		if(hrsz.isEmpty()){
        eredmeny.setText("Nincs címe a nyilvántartásban.");
        return;
    }
		else{
        for(int i=0; i<hrsz.size();++i){
            uzi.append(hrsz.get(i).getCim());
            uzi.append("   (");
            uzi.append(hrsz.get(i).getVarosresz());
            uzi.append(")\n");
        }
        eredmeny.setText(uzi.toString());
        return;
        }
    }
}
