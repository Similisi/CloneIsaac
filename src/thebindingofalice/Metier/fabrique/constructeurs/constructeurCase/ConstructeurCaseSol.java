package thebindingofalice.Metier.fabrique.constructeurs.constructeurCase;

import thebindingofalice.Metier.niveau.carte.Generateur.Case;
import thebindingofalice.Metier.niveau.carte.Generateur.CaseSol;

/**
 * Constructeur des cases sols
 * @author Arnaud
 */
public class ConstructeurCaseSol implements ConstructeurCase{

    @Override
    public Case Create(int colonne, int ligne) {
        return new CaseSol(colonne, ligne);
    }   
    
}
