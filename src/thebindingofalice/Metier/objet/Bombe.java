/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Metier.objet;

import javafx.animation.AnimationTimer;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Hitbox;
import thebindingofalice.Metier.ICollision;
import thebindingofalice.Metier.ennemis.Ennemi;
import thebindingofalice.Metier.joueur.Joueur;
import thebindingofalice.Metier.objet.obstacle.Obstacle;
import thebindingofalice.Metier.objet.obstacle.ObstacleDestructible;

/**
 *
 * @author noaba
 */
public class Bombe extends Obstacle {

    private Hitbox hitbox;
    private int tempoExpl=10000;
    private int degats=2; //la bombe fait un coeur de degats
    
    //Timer jusqu'à l'explosion de la bombe
    private AnimationTimer explTimer;
    
    private boolean hasExploded=false; //ce booléen existe car l'animation timer de l'explosion fait que la hitbox de la bombe collisione deux fois avec les autres objets
    
    public Bombe(Coordonnee c) {
        super(c);      
    }

    @Override
    public void evoluer(double pas) {
        explTimer = new AnimationTimer()
        {
            @Override
            public void handle(long pas) {      
                tempoExpl -= 1;
            }            
        };
        explTimer.start();
        if(this.tempoExpl<=0){
            //Créer la hitbox de l'explosion
            this.hitbox = new Hitbox(this.getCoordonnee().getX()-20, this.getCoordonnee().getY()-20, 100, 100);
            explTimer.stop();
            Notify("explosion");
        }
    }

    @Override
    public void Collision(ICollision o) {
       if(o instanceof Joueur){
           if(!hasExploded){
               ((Joueur) o).PrendDegat(degats);
           }
           else{
               hasExploded=false;
           }
           
       }
       if(o instanceof ObstacleDestructible){
           ((ObstacleDestructible) o).prendDegat(degats*50); //l'obstacle à 100 hp pour gérer les sprites
       }
       if(o instanceof Ennemi){
           if(!hasExploded){
               ((Ennemi) o).prendDegats(degats);
           }
           else{
               hasExploded=false;
           }
           
       }
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
    public boolean estUnProjectileAllie() {
        return false;
    }

    @Override
    public Hitbox getHitbox() {
        return hitbox;
    }
    
    @Override
    public TypeObjet getType() {
        return TypeObjet.BOMBE;
    }
}
