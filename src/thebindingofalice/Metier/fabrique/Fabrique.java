package thebindingofalice.Metier.fabrique;
import java.util.HashMap;

/**
 * Classe Multiton, gérant toutes les instances des fabriques abstraite.
 * @author Arnaud
 */
public abstract class Fabrique {
    private static final HashMap<TypeFabrique, Fabrique> instances = new HashMap<>();//instance du multiton

    /**
     * Méthode permettant d'enregistrer un fabrique
     * @param type le type que l'on souhaite ajouter
     * @param f la fabrique que l'on souhaite ajouter
     */
    public static void register(TypeFabrique type, Fabrique f) {
        instances.put(type, f);
    }

    /**
     * Méthode renvoyant une fabrique selon son type
     * @param key le type de fabrique voulu
     * @return la fabrique correspondant au type donné.
     */
    public static Fabrique get(TypeFabrique key) {
        if(!instances.containsKey(key))
        {
            createNewFabrique(key);
        }
        
        return instances.get(key);
    }
    
    private static void createNewFabrique(TypeFabrique type)
    {
        switch(type)
        {
            case CASE: new FabriqueCase(); break;
            case PROJECTILE: new FabriqueProjectile(); break;
            case PORTE: new FabriquePorte(); break;
            case ENNEMI: new FabriqueEnnemi(); break;
            default: throw new AssertionError(type.name());            
        }
    }
}
