package thebindingofalice.Metier.niveau.carte;

import thebindingofalice.Metier.niveau.carte.salle.DirectionSalle;
import thebindingofalice.Metier.niveau.carte.salle.Salle;
import java.util.ArrayList;
import thebindingofalice.Controller.Observable;

/**
 * Classe représentant la carte d'un niveau
 * @author Arnaud
 */
public class Carte extends Observable{
    private ArrayList<Salle> salles;        //liste des salles composant la carte
    private Salle salleCourante;            //salle courante

    public Carte() {
        this.salles = new ArrayList<>();
    }

    /**
     * Méthode renvoyant une copie de la liste des salles de la carte.
     * @return une copie de la liste des salles de la carte
     */
    public ArrayList<Salle> GetSalles() { return new ArrayList<>(salles); }
    
    public void setSalles(ArrayList<Salle> s)
    {
        salles = s;
        ChangerSalle(s.get(0));
    }
    
    /**
     * Accesseur de la salle courante
     * @return 
     */
    public Salle getSalleCourante() { return salleCourante; }

    /**
     * Méthode permettant de changer de salle courante selon la direction de la porte emprunté.
     * @param directionSalle direction de la porte emprunté.
     */
    public void ChangerSalle(DirectionSalle directionSalle) {
        
    }

    public void ChangerSalle(Salle s) {
        salleCourante = s;
        salleCourante.generateSalle();
        Notify("ChangeSalleCourante");
    }
    
    
}
