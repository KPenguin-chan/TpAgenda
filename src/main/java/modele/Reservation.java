package modele;
public class Reservation implements Comparable <Reservation>{


    private DateCalendrier date;
    private PlageHoraire plageHoraire;
    private String Titre;

    public String getNiveau() {
        return Niveau;
    }

    private String Niveau;

    public Reservation (DateCalendrier parDate, PlageHoraire parPlageHoraire, String parIntitule, String parNiveau) {
        date = parDate;
        plageHoraire = parPlageHoraire;
        Titre = parIntitule;
        Niveau = parNiveau;
    }

    public String toString() {
        return Titre + ", "+ date.toString() +"," + plageHoraire.toString();
    }


    public DateCalendrier getDate(){
        return date;
    }
    public PlageHoraire getPlageHoraire(){
        return plageHoraire;
    }

    public String getTitre(){
        return Titre;
    }
    public int compareTo(Reservation parReservation){
        if (date.compareTo(parReservation.date) == 0) {
            return plageHoraire.compareTo(parReservation.plageHoraire);
        }
        return date.compareTo(parReservation.date);
    }
    /**
     * Vérifie si la réservation est valide en tenant compte de la date et de la plage horaire.
     *
     * @return true si la réservation est valide, false sinon
     */
    public boolean estValide(){
        if (date.estValide() && plageHoraire.estValide()){
            return true;
        }
        return false;
    }



}
