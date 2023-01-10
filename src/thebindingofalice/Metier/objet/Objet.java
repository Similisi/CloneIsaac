package thebindingofalice.Metier.objet;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Evoluable;
import thebindingofalice.Metier.ICollision;

/**
 * Classe abstraite, héritant de Evoluable, représentant les objets au sols
 */
public abstract class Objet extends Evoluable implements ICollision {

    protected Objet(Coordonnee c) {
        super(c);
    }
    
    public abstract TypeObjet getType(); 
}