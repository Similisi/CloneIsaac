/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Metier.objet.obstacle;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Hitbox;
import thebindingofalice.Metier.ICollision;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.joueur.Joueur;
import thebindingofalice.Metier.niveau.carte.salle.DirectionSalle;
import thebindingofalice.Metier.niveau.carte.salle.Salle;
import thebindingofalice.Metier.objet.TypeObjet;

/**
 *Classe, héritant de Obstacle, représentant les portes
 * @author Pascaline
 */
public class Porte extends Obstacle{
    private final DirectionSalle direction;
    private final Hitbox hitbox;
    private boolean ouvert = false;
    private Salle salleNext;
    
    public Porte(Coordonnee c, DirectionSalle d) {
        super(c);
        hitbox = new Hitbox(c.getX(), c.getY(), 60, 60);
        direction = d;
    }

    @Override
    public TypeObjet getType() {
        return TypeObjet.PORTE;
    }

    @Override
    public void evoluer(double pas) {        
        if(!this.ouvert && Partie.get().getNiveauCourant().getSalleCourante().getEnnemis().isEmpty()){
            Notify("ouvert");
        }
    }

    @Override
    public void Collision(ICollision o) {
        if(o.EstLeJoueur() && ouvert)
        {
            Joueur joueur = Partie.get().GetJoueur();
            joueur.setCoordonnee(new Coordonnee(400, 200));
            //joueur.getHitbox().setPosition(joueur.getCoordonnee(), 0, 0);
            Partie.get().ChangerSalle(salleNext);
            
        }
    }

    @Override
    public boolean EstLeJoueur() {
        return false;
    }

    @Override
    public boolean EstBloquant() {
        return !ouvert;
    }

    @Override
    public boolean estUnProjectileAllie() {
        return false;
    }

    @Override
    public Hitbox getHitbox() {
        return hitbox;
    }

    public boolean isOuvert() {
        return ouvert;
    }

    public void setOuvert(boolean ouvert) {
        this.ouvert = ouvert;
    }
    
    public void setSalleNext(Salle salle) { this.salleNext = salle; }
    
    public Salle getSalleNext() { return salleNext; }
    
    public DirectionSalle getDirection() { return direction; }
    
}
