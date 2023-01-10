package thebindingofalice.Metier.objet.ramassable;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Hitbox;
import thebindingofalice.Metier.ICollision;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.objet.TypeObjet;

/**
 * Classe, héritant de ObjetRamassable, représentant les clés
 */
public class Cle extends ObjetRamassable {

    private Hitbox hitbox;
    public Cle(Coordonnee c) {
        super(c);
        this.hitbox = new Hitbox(c.getX(), c.getY(), 60, 60);
    }

    /**
     * /**
     *  * Méthode appelé à chaque frame du jeu. Le paramètre pas représente le pas de temps entre deux appel de la méthode.
     *  * /
     */
    public void evoluer(double pas) {

    }

    public void Collision(ICollision o) {
        if(o.EstLeJoueur())
            {
                Notify("giveclé");
                Partie.get().GetJoueur().AddCle(this);
            }
    }

    public boolean EstLeJoueur() {
            return false;
    }

    public boolean EstBloquant() {
            return false;
    }

    @Override
    public TypeObjet getType() {
        return TypeObjet.CLE;
    }

    @Override
    public Hitbox getHitbox() {
        return this.hitbox;
    }
    
    @Override
    public boolean estUnProjectileAllie() {
        return false;
    }
}