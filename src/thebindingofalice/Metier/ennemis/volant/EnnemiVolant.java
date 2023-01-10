package thebindingofalice.Metier.ennemis.volant;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.ennemis.Ennemi;

/**
 * Classe abstraite, héritant de Ennemi, représentant les ennemis volant
 */
public abstract class EnnemiVolant extends Ennemi {

    public EnnemiVolant(Coordonnee c) {
        super(c);
    }
}