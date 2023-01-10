/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import thebindingofalice.Controller.Observeur;
import thebindingofalice.Metier.Hitbox;

/**
 *
 * @author Noa
 * Classe IHM héritant de la classe Rectangle qui affiche la hitbox d'un élément
 */
public class HitboxView extends Rectangle implements Observeur{
    //Hitbox à afficher
    private final Hitbox h;
    
    /**
     * Constructeur de la vue d'une hitbox 
     * @param h hitbox à afficher
     */
    public HitboxView(Hitbox h) {
        //Construction du rectangle à partir des différentes coordonnées et valeur de la hitbox
        super(h.getX(),h.getY(),h.getWidth(),h.getHeight());
        this.h=h;
        //La vue observe la hitbox
        this.h.Register(this);
        //Rend transparent l'intérieur du rectangle
        this.setFill(Color.TRANSPARENT);
        //Rend transparent le contour du rectangle
        this.setStroke(Color.TRANSPARENT);
    }
    
    /**
     * Déplace la vue de la hitbox
     */
    private void moveHitboxView(){
        //Change la coordonnée en x
        this.setX(h.getX());
        //Change la coordonnée en y
        this.setY(h.getY());
    }

    @Override
    public void Update(String message) {
        if(message.toLowerCase().equals("hitbox"))
        {
            moveHitboxView();
        }
    }    
    
}
