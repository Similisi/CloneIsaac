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
import thebindingofalice.Metier.projectiles.ProjectileAllie;

/**
 * Classe qui représente n'importe quel obstacle destructible
 * @author noaba
 */
public class ObstacleDestructible extends Obstacle{

    private final Hitbox hitbox;
    private int hp=100; //les obstacles ont 100 hp cela permet de gérer le changement de sprite
    
    public ObstacleDestructible(Coordonnee c) {
        super(c);
        hitbox = new Hitbox(c.getX(), c.getY(), 60, 60);
    }

    @Override
    public TypeObjet getType() {
        return TypeObjet.OBSDESC;
    }

    @Override
    public void evoluer(double pas) {
        
    }

    @Override
    public void Collision(ICollision o) {
        //Si l'objet collisionable est une instance de projectile allie
        if(o instanceof ProjectileAllie){
            //on lui enlève un pv et on indique à la vue qu'il a été touché
            hp -= 25;
            Notify("touche");
        }
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
    public boolean estUnProjectileAllie() {
        return false;
    }

    @Override
    public Hitbox getHitbox() {
        return hitbox;
    }
    
    public int getHP(){
        return this.hp;
    }
    
    public void prendDegat(int degats){
        hp-=degats;
        Notify("touche");
    }
}
