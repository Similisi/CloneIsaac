package thebindingofalice.Metier.fabrique;

import thebindingofalice.Metier.niveau.carte.Generateur.CaseMur;
import thebindingofalice.Metier.niveau.carte.Generateur.Case;
import thebindingofalice.Metier.niveau.carte.Generateur.CasePorte;
import thebindingofalice.Metier.niveau.carte.Generateur.CaseSol;
import thebindingofalice.Metier.niveau.carte.Generateur.CaseVide;
import thebindingofalice.Metier.niveau.carte.Generateur.TypeCase;
/**
 * Fabrique gérant la création des cases
 * @author Arnaud
 */
public class FabriqueCase {

    /**
     * Méthode permettant de creér un case
     * @param type le type de la case
     * @param ligne la ligne de la case
     * @param colonne la colonne de la case
     * @return la case ainsi créer
     */
    public static Case Create(TypeCase type, int colonne, int ligne) {
        Case c = null;
        
        switch(type)
        {
            case MUR: c = new CaseMur(colonne, ligne); break; 
            case SOL: c = new CaseSol(colonne, ligne); break; 
            case VIDE: c = new CaseVide(colonne, ligne); break;
            case PORTE: c = new CasePorte(colonne, ligne); break;
            default:
                throw new AssertionError(type.name());
            
        }
        
        return c;
    }
}