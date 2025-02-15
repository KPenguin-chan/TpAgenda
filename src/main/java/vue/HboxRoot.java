package vue;

import controleur.Controleur;
import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import modele.*;

public class HboxRoot extends HBox {
    private static PlanningCollections planning;
    private static Controleur controleur;
    private static VboxCalendrier calendrierPane;
    private static GridPaneFormulaireReservation reservationPane;
    private static VBoxAffichagePlanning affichagePlanning;


    public HboxRoot (){

        planning = new PlanningCollections();
        controleur = new Controleur();
        calendrierPane = new VboxCalendrier();
        reservationPane = new GridPaneFormulaireReservation();
        affichagePlanning = new VBoxAffichagePlanning();
        this.getChildren().add(calendrierPane);
        this.getChildren().add(reservationPane);
        this.getChildren().add(affichagePlanning);
    }

    public static PlanningCollections getPlanning() {
        return planning;
    }

    public static Controleur getControleur() {
        return controleur;
    }

    public static GridPaneFormulaireReservation getReservationPane() {
        return reservationPane;
    }

    public static VBoxAffichagePlanning getAffichagePlanning() {
        return affichagePlanning;
    }
}

