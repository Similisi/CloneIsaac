/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Metier.objet.HUD;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Hitbox;
import thebindingofalice.Metier.ICollision;
import thebindingofalice.Metier.objet.TypeObjet;
import thebindingofalice.Metier.objet.obstacle.Obstacle;

/**
 *
 * @author johann
 */
public class CoeurHUDGauche extends Obstacle{

    public CoeurHUDGauche(Coordonnee c) {
        super(c);
    }

    
    @Override
    public TypeObjet getType() {
        return TypeObjet.CoeurGaucheHUD;
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
        return false;
    }

    @Override
    public Hitbox getHitbox() {
        return null;
    }
    @Override
    public boolean estUnProjectileAllie() {
        return false;
    }
}
