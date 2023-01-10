/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM.view;

import javafx.scene.paint.Color;
import thebindingofalice.Controller.ControlleurChauveSouris;
import thebindingofalice.Controller.Observeur;
import thebindingofalice.IHM.GamePane;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.ennemis.volant.ChauveSouris;

/**
 *
 * @author Pascaline
 */
public class ChauveSourisView extends View implements Observeur{
    
    //Joueur à afficher
    private final ChauveSouris chauveSouris;
    //Controlleur du joueur
    private final ControlleurChauveSouris controlleurChauveSouris;
    //Vue de la hitbox du joueur à afficher
    private final HitboxView hitboxChauveSouris;

    public ChauveSourisView(ChauveSouris cS) {
        super(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Sprites/Ennemis/chauveSouris.png");
        chauveSouris = cS;
        chauveSouris.Register(this);
        
        hitboxChauveSouris = new HitboxView(cS.getHitbox());
         //change la couleur du contour de la hitbox (à commenter pour laisser transparent)
        //hitboxChauveSouris.setStroke(Color.RED);
        //ajoute la hitbox de la chauvesouris sur l'affichage
        GamePane.get().addView(hitboxChauveSouris);
        
        //ajoute la chauvesouris à la liste des evoluable et des collisions de la partie
        Partie.get().getNiveauCourant().getSalleCourante().AddEvoluable(chauveSouris);
        Partie.get().getNiveauCourant().getSalleCourante().addEnnemi(chauveSouris);
        Partie.get().addICollision(chauveSouris);
        
        this.controlleurChauveSouris = new ControlleurChauveSouris(chauveSouris);
        
    }

    public void moveSprite()
    {
        Coordonnee coordonnee = chauveSouris.getCoordonnee();
        translate(coordonnee.getX() , coordonnee.getY());
    }
    
    @Override
    public void Update(String message) {
        switch(message.toLowerCase())
        {
            case "chauvesourisdeplacement": moveSprite(); break;
            case "destroy" : destroy(); System.out.println("cv meurt");break;
            default : break;
        }
    }

    private void destroy() {
        Partie.get().RemoveICollision(chauveSouris);
        Partie.get().getNiveauCourant().getSalleCourante().RemoveEvoluable(chauveSouris);
        Partie.get().getNiveauCourant().getSalleCourante().removeEnnemi(chauveSouris);
        GamePane.get().removeView(hitboxChauveSouris);
        GamePane.get().removeView(this);
    }
    
    
}
