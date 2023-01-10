package thebindingofalice.Metier.fabrique.constructeurs.constructeurCase;

import thebindingofalice.Metier.niveau.carte.Generateur.Case;
import thebindingofalice.Metier.niveau.carte.Generateur.CaseVide;

/**
 * Constructeur Case vide
 * @author Arnaud
 */
public class ConstructeurCaseVide implements ConstructeurCase{

    @Override
    public Case Create(int colonne, int ligne) {
        return new CaseVide(colonne, ligne);
    }    
}
