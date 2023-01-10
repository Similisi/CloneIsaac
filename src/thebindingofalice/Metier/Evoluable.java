package thebindingofalice.Metier;

import thebindingofalice.Controller.Observable;


/**
 * Classe abstraite, représentant les objets pouvant evoluer au cours du temps.
 */
public abstract class Evoluable extends Observable{
    private Coordonnee coordonnee;

    protected Evoluable(Coordonnee c) {
        coordonnee = c;
    }
        
    public Coordonnee getCoordonnee() { return coordonnee; }
    
    public void setCoordonnee(Coordonnee c) { coordonnee = c; }
    
    /**
     * Méthode appelé à chaque frame du jeu.Le paramètre pas représente le pas de temps entre deux appel de la méthode.
     * @param pas
     */
    public abstract void evoluer(double pas);
}