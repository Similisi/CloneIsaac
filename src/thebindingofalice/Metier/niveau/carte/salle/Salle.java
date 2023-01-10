package thebindingofalice.Metier.niveau.carte.salle;

import java.util.ArrayList;
import java.util.HashMap;
import thebindingofalice.Controller.Observable;
import thebindingofalice.Metier.Evoluable;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.ennemis.Ennemi;
import thebindingofalice.Metier.joueur.Joueur;
import thebindingofalice.Metier.niveau.carte.Generateur.Case;
import thebindingofalice.Metier.objet.obstacle.Obstacle;
import thebindingofalice.Metier.objet.obstacle.Porte;
import thebindingofalice.Metier.objet.ramassable.ObjetRamassable;

/**
 * Classe abstraite représentant les salles. Elle est composé de cases.
 * @author Arnaud
 */
public abstract class Salle extends Observable{
    private final ArrayList<Case> cases;                    //Liste des cases composant la salle
    private final HashMap<DirectionSalle, Salle> voisins;    //Liste des portes de la salle
    private final ArrayList<Evoluable> evoluables;          //Liste des evoluables présent dans la salle
    private final ArrayList<Ennemi> ennemies;
    private boolean finished = false;
    
    
    public Salle() {
        this.evoluables = new ArrayList<>();
        this.voisins = new HashMap<>();
        this.cases = new ArrayList<>();
        this.ennemies = new ArrayList<>();
        
        for(DirectionSalle dir : DirectionSalle.values())
        {
            voisins.put(dir, null);
        }
    }

    public void addVoisin(DirectionSalle dir, Salle s) { voisins.put(dir, s); }
    
    public void addEnnemi(Ennemi e) { ennemies.add(e); }
    
    public void removeEnnemi(Ennemi e) {
        System.out.println("ennemi removed");
        ennemies.remove(e); 
        if(ennemies.isEmpty())
        {
            Notify("loot");
            finished = true;
        }
    }
    
    /**
     * Méthode permettant d'ajouter un évoluable à la salle.
     *
     * @param e évoluable
     */
    public void AddEvoluable(Evoluable e) {
        evoluables.add(e);
    }

    /**
     * Méthode permettant de supprimer un évoluable de la salle.
     *
     * @param e évoluable que l'on souhaite supprimer
     * @return true si l'élément était présent dans la liste, false sinon
     */
    public boolean RemoveEvoluable(Evoluable e) {
        return evoluables.remove(e);
    }

    /**
     * Méthode permettant de retourner une copie des cases de la salle.
     *
     * @return une copie des cases de la salle.
     */
    public ArrayList<Case> getCases() {
        return new ArrayList<>(cases);
    }

    public ArrayList<Evoluable> getEvoluables() {
        return evoluables;
    }
    
    /**
     * Méthode permettant d'ajouter une case à la salle.
     *
     * @param c la case que l'on souhaite ajouter.
     */
    protected void AddCase(Case c) {
        cases.add(c);
    }

    /**
     * Accesseur du type de la salle.
     *
     * @return le type de la salle
     */
    public abstract TypeSalle getType();

    /**
     * Accesseur de la taille de coté de la salle
     *
     * @return la taille de coté de la salle
     */
    public static int getTailleCote() {
        return 11;
    }

    public void evoluer(double pas) {
        for(int i = 0; i < evoluables.size(); i++)
        {
            evoluables.get(i).evoluer(pas);
        }
    }

    /**
     * Méthode créant les ennemis de la salle.
     * @return renvoie les ennemis créés.
     */
    public abstract ArrayList<Ennemi> instanciateEnnemis();
    
    /**
     * Méthode créant les objets ramassables de la salle.
     * @return renvoie les objets ramassables créés.
     */
    public abstract ArrayList<ObjetRamassable> instanciateRamassable();
    
    /**
     * Méthode créant les obstacles de la salle.
     * @return renvoie les obstacles créés.
     */
    public abstract ArrayList<Obstacle> instanciateObstacle();
    
    public abstract void generateSalle();
    
    /**
     * Méthode appelé lors d'un game over,
     * vide la liste des ennemies et celle des evoluables
     */
    public void PartiePerdu() {
        this.ennemies.clear();
        this.evoluables.clear();
        voisins.clear();
        cases.clear();
    }
    
    public ArrayList<Ennemi> getEnnemis(){
        return this.ennemies;    
    }
               
    public HashMap<DirectionSalle, Salle> getVoisins()
    {
        return voisins;
    }

    public void addJoueur() {
        Joueur joueur = Partie.get().GetJoueur();
        if(!evoluables.contains(joueur))
        {
            AddEvoluable(joueur);
            Partie.get().addJoueurCollision();
            Notify("AddJoueur");
            
        }
    }
    
    public boolean isFinished() { return finished; }
    
    public void clearEvoluables()
    {
        evoluables.clear();
    }
    
    public void clearCases()
    {
        cases.clear();
    }
}
