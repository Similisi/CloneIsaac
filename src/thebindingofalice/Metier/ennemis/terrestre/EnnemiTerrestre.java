package thebindingofalice.Metier.ennemis.terrestre;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.ennemis.Ennemi;

/**
 * Classe abstraite, héritant de Ennemi, représentant les ennemis terrestres
 */
public abstract class EnnemiTerrestre extends Ennemi {

    public EnnemiTerrestre(Coordonnee c) {
        super(c);
    }
}