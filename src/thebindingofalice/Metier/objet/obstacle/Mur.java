package thebindingofalice.Metier.objet.obstacle;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Hitbox;
import thebindingofalice.Metier.ICollision;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.ennemis.Ennemi;
import thebindingofalice.Metier.joueur.Joueur;
import thebindingofalice.Metier.niveau.carte.Generateur.CaseMur;
import thebindingofalice.Metier.niveau.carte.salle.DirectionSalle;
import thebindingofalice.Metier.niveau.carte.salle.Salle;
import thebindingofalice.Metier.objet.TypeObjet;

/**
 * Classe, héritant de Obstacle, représentant les murs
 */
public class Mur extends Obstacle {
    private final Hitbox hitbox;
    private int i = 0;
    public Mur(Coordonnee c) {
        super(c);
        hitbox = new Hitbox(c.getX(), c.getY(), 60, 60);
    } 
    
    @Override
    public TypeObjet getType() {
        return TypeObjet.MUR;
    }

    @Override
    public void evoluer(double pas) {
        
    }

    @Override
    public void Collision(ICollision o) {
        
    }

    @Override
    public boolean EstLeJoueur() {
        return false;
    }

    @Override
    public boolean EstBloquant() {
        return true;
    }

    @Override
    public Hitbox getHitbox() {
        return hitbox;
    }
    
    @Override
    public boolean estUnProjectileAllie() {
        return false;
    }
}