package thebindingofalice.Metier;
/**
 * Interface représentant les objets avec des collisions
 */
public interface ICollision {

    /**
     * Méthode appelé quand l'objet est touché par un autre ICollision
     * @param o l'objet qui touche celui-ci
     */
    public void Collision(ICollision o);

    /**
     * Méthode retournant si l'objet est le joueur
     * @return vrai si c'est le joueur, faux sinon
     */
    public boolean EstLeJoueur();

    /**
     * Méthode renvoyant si l'objet est bloquant.
     * @return vrai si bloquant, faux sinon
     */
    public boolean EstBloquant();
    
    /**
     * Méthode renvoyant vrai si l'objet est un projectileAllie
     * @return vrai si l'objet est un projectileAllie, faux sinon
     */
    public boolean estUnProjectileAllie();
    
    /**
     * Accesseur de l'hitbox de l'objet
     * @return l'hitbox de l'objet
     */
    public Hitbox getHitbox(); 
}