package modele;

public class ExceptionPlanning extends Exception implements ConstanteErreur {
    private int chCodeErreur;

    public ExceptionPlanning (int parCodeErreur){
        chCodeErreur = parCodeErreur;
    }

    public int getCodeErreur() {
        return chCodeErreur;
    }
    public String getMessage(){
        return ConstanteErreur.ERREURS_PLANNING[chCodeErreur];
    }
}
