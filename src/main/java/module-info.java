module com.example.projetagenda {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.projetagenda to javafx.fxml;
    exports com.example.projetagenda;
    exports vue;
    exports modele;
    exports controleur;
}