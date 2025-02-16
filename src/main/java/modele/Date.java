package modele;

import java.io.Serializable;
import java.util.Calendar;

public class Date implements Serializable {
	/** Un enter représentant un jour */
	protected int chJour;
	/** Un entier représentant un mois */
	protected int chMois;
	/** Un entier représentant une année */
	protected int chAnnee;

	/** Constructeur de la classe Date
	 *
	 * @param parJour un enter représentant un jour
	 * @param parMois un entier représentant un mois
	 * @param parAnnee un entier représentant une année
	 */
	public Date(int parJour, int parMois, int parAnnee){
		chJour = parJour;
		chMois = parMois;
		chAnnee = parAnnee;
	}

	/** Constructeur de la classe Date qui créé la date 01/01/chAnnée
	 *
	 * @param parAnnee un entier représentant une année
	 */
	public Date(int parAnnee){
		chJour = 1;
		chMois = 1;
		chAnnee = parAnnee;
	}

  public Date() {
	  Calendar dateAuj = Calendar.getInstance();
	  chAnnee = dateAuj.get (Calendar.YEAR);
	  chMois = dateAuj.get (Calendar.MONTH) + 1;
	  chJour = dateAuj.get (Calendar.DAY_OF_MONTH);
  }

	/**
	 * Cette méthode ne prend pas de paramètres et renvoie si une date est valide,si une date respecte les condition.
	 * Qui sont les suivantes : l'année est supérieur à 1582, le mois compris entre 1 et 12 et le jour compris entre 1 et le dernier jour du mois.
	 * Elle renvoie soit null ou l'ensemble des réservations du planning ayant pour date la date en paramètre.
	 * Elle renvoie un booléen. True si toute les conditions sont respecté et sinon elle renvoie False/
	 * @return False or True
	 */
	public boolean estValide() {
		if (chAnnee < 1583) {
			return false; // On n’accepte pas les dates avant 1583
		}

		if (chMois < 1 || chMois > 12) {
			return false; // Mois doit être entre 1 et 12
		}

		if (chJour < 1 || chJour > dernierJourDuMois(chMois, chAnnee)) {
			return false; // Jour doit être valide pour le mois et l'année donnés
		}

		return true;
	}



	/**
	 * Cette méthode prend en paramètre une mois et une année de type int. Avec ces paramètres elle est capable d'identifier le dernier du mois avec des tests.
	 * Elle renvoie soit le dernier jour du mois qui peut être soit 28, 29, 30 ou 31 par défaut.
	 * @param parMois
	 * @param parAnnee
	 * @return jour
	 */
  
protected static int dernierJourDuMois (int parMois, int parAnnee) {
	switch (parMois) {
		 case 2 : if (Date.estBissextile (parAnnee))
		 			  return 29 ; 
				  return 28 ;  
		 case 4 : 	 
		 case 6 : 	 
		 case 9 : 	 
		 case 11 : return 30 ;
		 default : return 31 ;
	}   
  }
	/**
	 * Cette méthode prend en paramètre une année et identifie si l'année est bissextile.
	 * Elle renvoie soit True ou False
	 * @param parAnnee
	 * @return True or False
	 */
  private static boolean estBissextile(int parAnnee) {
		return (parAnnee % 4 == 0 && parAnnee % 100 != 0) || parAnnee % 400 == 0;
  }


	/** compareTo compare this avec parDate
	 *
	 * @param parDate une date
	 * @return 0 si this et parDate sont égaux, un négatif si this < parDate ou
	 *          un positif si this > parDate
	 */
	public int compareTo (Date parDate) {
		if (this.chAnnee < parDate.chAnnee)
			return -1;
		if (this.chAnnee > parDate.chAnnee)
			return 1;

		if (this.chMois < parDate.chMois)
			return -1;
		if (this.chMois > parDate.chMois)
			return 1;

		if (this.chJour < parDate.chJour)
			return -1;
		if (this.chJour > parDate.chJour)
			return 1;

		return 0;
	}

	/**dateDuLendemain renvoie la date du lendemain de this
	 *
	 * @return la date du lendemain
	 */
	public Date dateDuLendemain () {
		if (this.chJour + 1 <= dernierJourDuMois(this.chMois, this.chAnnee))
			return new Date(chJour + 1, this.chMois, this.chAnnee);
		else {
			if (this.chMois + 1 <= 12)
				return new Date(1, this.chMois + 1, this.chAnnee);
			else
				return new Date(this.chAnnee + 1);
		}
	}
	/**dateDeLaVeille renvoie la date de la veille de this
	 *
	 * @return la date de la veille
	 */
	public Date dateDeLaVeille () {
		if (this.chJour - 1 >= 1)
			return new Date(chJour - 1, this.chMois, this.chAnnee);
		else {
			if (this.chMois - 1 >= 1)
				return new Date(dernierJourDuMois(this.chMois-1, this.chAnnee), this.chMois - 1, this.chAnnee);
			else
				return new Date(31, 12, this.chAnnee - 1);
		}
	}
  
  public int getAnnee() { 
	return chAnnee;
}

public int getJour() { 
	return chJour;
}

public  int getMois() {
	return chMois;
}
  public String toString () { 
    return  chJour + "-" + chMois + "-" +chAnnee;
  }   
  

}   