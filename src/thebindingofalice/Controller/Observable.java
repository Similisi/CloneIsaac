package thebindingofalice.Controller;

import java.util.ArrayList;

/**
 * Classe abstraite représentant les observables qui peuvent notifier les oberseveurs d'un changement du model.
 * @author Arnaud
 */
public abstract class Observable {
    private final ArrayList<Observeur> obs;   //observable à avertir

    protected Observable() {
        obs = new ArrayList<>();
    }
    
    /**
     * Méthode permettant de s'enregistrer à cet observable. La vue sera averti en cas de changement du model.
     * @param o Observeur à enregistrer.
     */
    public void Register(Observeur o){ obs.add(o); }
    
    
    /**
     * Méthode permettant de s'enregistrer à cet observable. La vue sera averti en cas de changement du model.
     * Cette méthode vérifie si l'observeur à déjà été ajouté et ne l'ajoute que s'il n'y est pas déjà.
     * @param o Observeur à enregistrer.
     */
    public void RegisterOnce(Observeur o)
    {
        if(!obs.contains(o))
        {
            Register(o);
        }
    }
    
    
    /**
     * Méthode, appelé lors d'un changement du model, avertissant toutes les vues du changement.
     * @param message Destinataire du changement.
     */
    protected void Notify(String message)
    {
        for(Observeur o : obs)
        {
           o.Update(message);
        }
    }
}
