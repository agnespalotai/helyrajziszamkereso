package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Helyrajzi-szám ellenőrző program.
 * A felhasználótól bekér egy sztringet, majd megvizsgálja, hogy
 * az megfelel-e egy helyrajzi-szám formátumának, maj az ellenőrzés
 * eredményének megfelelő üzenetet ír ki.
 * @author Palotai Ágnes
 * @version 1.0
 */
public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/view.fxml"));
        primaryStage.setTitle("Helyrajzi-szám ellenőrzése");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * Az alkalméazás belépési pontja.
     * @param args argumentum
     */
    public static void main(String[] args) {
        launch(args);
    }

}