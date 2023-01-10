package thebindingofalice.Metier.objet.ramassable;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.objet.Objet;

/**
 * Classe abstraite, héritant de Objet, représentant les objets que l'on peut ramasser.
 */
public abstract class ObjetRamassable extends Objet {

    protected ObjetRamassable(Coordonnee c) {
        super(c);
    }
}