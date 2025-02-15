package modele;
public class Horaire {

    private int chHeure;

    private int chQuartHeure;
    /**Construit un objet de la classe Horaire en affectant les paramètres parHeure et parQuartHeure aux champs
     * chHeure et chQuartHeure
     *
     * @param parHeure le paramètre à affecter au champ chHeure
     * @param parQuartHeure le paramètre à affecter au champ chQuartHeure
     */

    public Horaire (int parHeure, int parQuartHeure) {

        chHeure = parHeure;

        chQuartHeure = parQuartHeure;

    }

    /**Renvoie la conversion de l'horaire en minutes
     *
     * @return la conversion de l'horaire en minutes
     */
    public int toMinutes () {

        return chHeure*60 + chQuartHeure;

    }

    public int getHeure () {

        return chHeure;

    }

    public int getQuartHeure () {

        return chQuartHeure;

    }

    public void setHeure (int parHeure) {

        chHeure = parHeure;

    }

    public void setQuartHeure (int parQuartHeure) {
        chQuartHeure = parQuartHeure;

    }

    public String toString () {
        return chHeure + "h" + chQuartHeure;

    }
    /**Teste si l'horaire est valide. C'est à dire si les minutes sont un quart d'heure, si l'heure est entre 0 et 23
     * compris et si le quart d'heure est entre 0 et 59 compris.
     *
     * @return false si l'horaire n'est pas valide et true si il l'est
     */
    public boolean estValide() {
        if (chQuartHeure % 15 != 0)
            return false;
        if (chHeure < 0 || chHeure > 23)
            return false;
        if (chQuartHeure < 0 || chQuartHeure > 59)
            return false;
        return true;
    }



}
