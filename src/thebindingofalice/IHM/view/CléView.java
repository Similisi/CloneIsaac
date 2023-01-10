/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM.view;

import javafx.scene.paint.Color;
import thebindingofalice.Controller.Observeur;
import thebindingofalice.IHM.GamePane;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.objet.ramassable.Cle;

/**
 *
 * @author johann
 */
public class CléView extends View implements Observeur{

    private Cle clé;
    
    private HitboxView hitboxClé;
    
    public CléView(Cle c) {
        super(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Sprites/clé.png");
        this.clé = c;
        
        clé.Register(this);
        
        hitboxClé = new HitboxView(c.getHitbox());
        //change la couleur du contour de la hitbox (à commenter pour laisser transparent)
        //hitboxClé.setStroke(Color.RED);
        //ajoute la hitbox du joueur sur l'affichage
        GamePane.get().addView(hitboxClé);
        
        //ajoute le coueur à liste des evoluable et des collisions de la partie
        Partie.get().getNiveauCourant().getSalleCourante().AddEvoluable(clé);
        Partie.get().addICollision(clé);  
        
        setFitHeight(50);
        setFitWidth(50);
        //Affiche le coeur au bon endroit
        translate(clé.getCoordonnee().getX(),clé.getCoordonnee().getY());
    }

    
    @Override
    public void Update(String message) {
        if(message.toLowerCase().equals("giveclé"))
        {
            Ajout();
        }
    }

    private void Ajout() {
        Partie.get().getNiveauCourant().getSalleCourante().RemoveEvoluable(this.clé);
        Partie.get().RemoveICollision(this.clé);
        GamePane.get().removeView(this.hitboxClé);
        GamePane.get().removeView(this);
    }
    
}
