package modele;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    void getReservations() throws ExceptionPlanning {

        /*
        2)Les différences qu'on peut voir sont le type de la liste qui est un hashset qui fait que la manière de parcourir est différente,7
            Il y a également un test dans le cas d'une liste vide qui permet de renvoyer null. Ces changments n'affecte pas les test à faire
            car c'est la même méthode dans l'ensemble.

        */

        PlageHoraire ph1 = new PlageHoraire(new Horaire(20,30),new Horaire(23,15));
        PlageHoraire ph2 = new PlageHoraire(new Horaire(10,30),new Horaire(15,15));
        Reservation r1 = new Reservation(new DateCalendrier(5,2,2025),ph1,"788","expert");
        Reservation r2 = new Reservation(new DateCalendrier(3,1,1999),ph1,"111","expert");
        Reservation r3 = new Reservation(new DateCalendrier(5,2,2025),ph2,"4414","expert");
        Reservation r4 = new Reservation(new DateCalendrier(7,4,2024),ph1,"788","expert");

        PlanningCollections p1 = new PlanningCollections();
        PlanningCollections p2 = new PlanningCollections();
        PlanningCollections expectedPlanning = new PlanningCollections();

        p1.ajout(r1);
        p1.ajout(r2);
        p1.ajout(r3);
        expectedPlanning.ajout(r1);
        expectedPlanning.ajout(r3);


        assertEquals(expectedPlanning.getChSetReservations(), p1.getReservations(r1.getDate()));
        assertNull( p1.getReservations(r4.getDate()));
        assertNull(p2.getReservations(r4.getDate()));
    }

/* 2)La méthode plusAncienneReservation n'existe pas dans PlanningCollections mais si elle devait exister au sein
* de planningCollections elle ne servirait pas à grand chose car l'indice de la plus Ancienne Réservation est 0 étant donné
* que les réservation sont stockés dans un TreeSet
*
*
* 2)La méthode Tri n'existe pas non plus car les réservations sont dans un TreeSet.*/


}