package thebindingofalice.Metier.ennemis;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.joueur.DirectionDeplacement;
import thebindingofalice.Metier.Evoluable;
import thebindingofalice.Metier.ICollision;
import thebindingofalice.Metier.Statistiques;

/**
 * Classe abstraite, héritant de Evoluable et de ICollision, représentant les ennemis du jeu
 */
public abstract class Ennemi extends Evoluable implements ICollision {
    private int vie;
    private Statistiques statistiques;
    private double vitesseX;
    private double vitesseY;

    public Ennemi(Coordonnee c) {
        super(c);
        statistiques = new Statistiques();
    }

    public abstract TypeEnnemi getType();
    
    public void Bouger(DirectionDeplacement dir) {
            throw new UnsupportedOperationException();
    }

    protected Statistiques getStatistiques() {
        return statistiques;
    }

    protected double getVitesseX() {
        return vitesseX;
    }

    protected void setVitesseX(double vitesseX) {
        this.vitesseX = vitesseX;
    }

    protected double getVitesseY() {
        return vitesseY;
    }

    protected void setVitesseY(double vitesseY) {
        this.vitesseY = vitesseY;
    }
    
    /**
     * Méthode pour prendre des dégats
     * @param degats 1 degat vaut un demie coeur de vie
     */
    public void prendDegats(int degats){
        vie -=degats;
    }
    
}