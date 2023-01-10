package thebindingofalice.Controller;

import thebindingofalice.Metier.niveau.Niveau;
import thebindingofalice.Metier.niveau.carte.salle.DirectionSalle;

/**
 * Classe, héritant de Observable, représentant le controlleur de niveau
 * @author Arnaud
 */
public class ControlleurNiveau extends Observable{
    private Niveau niveau;      //le niveau

    public ControlleurNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
    
    /**
     * Méthode permettant de changer de salle selon la direction de la porte emprunté.
     * @param d la direction de la porte.
     */
    public void ChangerSalle(DirectionSalle d)
    {
        //TODO
        Notify("niveau");
    }

    /**
     * Accesseur du niveau
     * @return 
     */
    public Niveau getNiveau() { return niveau; }
    
    /**
     * Mutateur du niveau
     * @param n le niveau
     */
    public void setNiveau(Niveau n) { niveau = n; }
}
