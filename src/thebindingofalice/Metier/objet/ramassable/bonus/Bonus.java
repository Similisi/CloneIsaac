package thebindingofalice.Metier.objet.ramassable.bonus;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.objet.ramassable.ObjetRamassable;

/**
 * Classe abstraite, héritant de ObjetRamassable, représentant les bonus du jeu
 */
public abstract class Bonus extends ObjetRamassable {

    protected Bonus(Coordonnee c) {
        super(c);
    }
    
    public abstract void effet();
}