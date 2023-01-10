/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Metier.objet.obstacle;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Hitbox;
import thebindingofalice.Metier.ICollision;
import thebindingofalice.Metier.objet.TypeObjet;

/**
 *
 * @author Guillaume
 */
public class Rocher extends Obstacle{
    private final Hitbox hitbox;

    public Rocher(Coordonnee c) {
        super(c);
        hitbox = new Hitbox(c.getX(), c.getY(), 60, 60);
    }

    @Override
    public TypeObjet getType() {
        return TypeObjet.ROCHER;
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
