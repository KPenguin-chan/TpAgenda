package modele;

public class PlageHoraire  {

    private  Horaire chDebut;

    private  Horaire chFin;

   private final static int  DUREEMIN = 60;

    public String toString () {
        Horaire duree = duree();
        return chDebut +  "-"+ chFin + " durée : "+ duree ;

    }
    /**Construit un objet de la classe PlageHoraire en affectant les paramètres parHoraireDebut et parHoraireFin
     * aux champs chHoraireDebut et chHoraireFin
     *
     * @param parDebut le paramètre à affecter au champ chHoraireDebut
     * @param parFin le paramètre à affecter au champ chHoraireFin
     */
    public PlageHoraire(Horaire parDebut, Horaire parFin) {
        chDebut = parDebut;
        chFin= parFin;

    }

    /**Teste si la plage horaire est valide. C'est à dire si les horaires de début et de fin sont valide, si l'horaire
     * de fin est bien après l'horaire de début et si la durée est inférieur à la durée minimum.
     *
     * @return false si la plage horaire n'est pas valide et true si elle l'est
     */
    public boolean estValide () {
        if (!chDebut.estValide() || !chFin.estValide())
            return false;
        if (chFin.toMinutes() < chDebut.toMinutes())
            return false;
        if (chFin.toMinutes() - chDebut.toMinutes() < DUREEMIN)
            return false;
        return true;
    }

    /**compareTo compare la plage horaire this avec parpH.
     *
     * @param parpH une plage horaire
     * @return un négatif si this précède parpH, un positif si parpH précède this et un nul sinon(égalité, chevauchement,
     * inclusion)
     */
    public int compareTo (PlageHoraire parpH) {
        if (parpH.chDebut.toMinutes() >= chFin.toMinutes())
            return -1;
        else if (parpH.chFin.toMinutes() <= chDebut.toMinutes())
            return 1;
        else
            return 0;
    }
    /**Renvoie la durée entre l'horaire de début et l'horaire de fin
     *
     * @return un horaire représentant la durée entre les horaires de début et fin
     */
    public Horaire duree() {
        return new Horaire (chFin.getHeure() - chDebut.getHeure(),
                chFin.getQuartHeure() - chDebut.getQuartHeure());
    }


}
