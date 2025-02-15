package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class AgendaApp extends Application {
    public void start(Stage stage)   {

        /*VBox root = new VboxCalendrier();*/
        HboxRoot root = new HboxRoot();

        Scene scene = new Scene(root,1200,400);

        File[] fichierCss = new File("css").listFiles();
    for (File fichier : fichierCss) {
        scene.getStylesheets().add(fichier.toURI().toString());
    }


        stage.setScene(scene);

        stage.setTitle("Hello JavaFX");

        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
