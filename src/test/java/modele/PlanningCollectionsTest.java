package modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanningCollectionsTest {

    @Test
    void ajout() throws ExceptionPlanning {
        PlageHoraire ph1 = new PlageHoraire(new Horaire(20,30),new Horaire(23,15));
        Reservation r1 = new Reservation(new DateCalendrier(28,3,2025),ph1,"788","expert");
        Reservation r2 = new Reservation(new DateCalendrier(22,2,2025),ph1,"111","expert");

        PlanningCollections p1 = new PlanningCollections();

        PlanningCollections expectedPlanning = new PlanningCollections();
        p1.ajout(r2);
        p1.ajout(r1);

        expectedPlanning.ajout(r2);
        expectedPlanning.ajout(r1);

        /*
        2)Les différences qu'on peut voir sont que la liste n'est pas limiter en taille
        donc pas besoin de tester l'ajout en cas de liste pleine et la fonction ajout
        de projet émet une exception pour une date fausse
        */


        assertTrue(expectedPlanning.compareTo(p1));
    }

    @Test
    void getReservations() {
    }
}