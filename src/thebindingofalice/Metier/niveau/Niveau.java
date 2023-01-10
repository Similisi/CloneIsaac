package thebindingofalice.Metier.niveau;

import thebindingofalice.Metier.niveau.carte.salle.DirectionSalle;
import thebindingofalice.Metier.niveau.carte.Carte;
import thebindingofalice.Metier.niveau.carte.salle.Salle;

/**
 * Classe représentant les niveaux du jeu.
 * @author Arnaud
 */
public class Niveau {
    private final Carte carte;      //Carte du niveau

    public Niveau() {
        carte = new Carte();
    }   

    /**
     * Méthode renvoyant la salle courante de la carte.
     * @return la salle courante.
     */
    public Salle getSalleCourante() { return carte.getSalleCourante(); }
    
    /**
     * Accesseur de la carte
     * @return 
     */
    public Carte getCarte() { return carte; }

    /**
     * Méthode permettant de changer de salle selon la direction de la porte emprunté.
     * @param d la direction de la porte.
     */
    public void ChangerSalle(DirectionSalle d) {
            throw new UnsupportedOperationException();
    }

    public void ChangerSalle(Salle s) {
        carte.ChangerSalle(s);
    }
}