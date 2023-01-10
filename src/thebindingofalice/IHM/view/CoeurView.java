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
import thebindingofalice.Metier.objet.ramassable.Coeur;


/**
 *
 * @author Pascaline
 * Classe représentant un coeur sur l'IHM
 */
public class CoeurView  extends View implements Observeur{
    //Coeur représente
    private final Coeur coeur;
    //Vue de la hitbox du coeur représenté à afficher
    private final HitboxView hitboxCoeur;
    
    /**
     * Constructeur de l'affichage du coeur
     * @param c le coeur qu'on veut afficherr
     */
    public CoeurView(Coeur c) {
        //On passe en paramètre le sprite du coeur
        super(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Sprites/coeur.png");
        this.coeur = c;
        //Le coeur est observé par la vue
        coeur.Register(this);
        
        hitboxCoeur = new HitboxView(c.getHitbox());
        //change la couleur du contour de la hitbox (à commenter pour laisser transparent)
        //hitboxCoeur.setStroke(Color.RED);
        //ajoute la hitbox du joueur sur l'affichage
        GamePane.get().addView(hitboxCoeur);
        
        //ajoute le coueur à liste des evoluable et des collisions de la partie
        Partie.get().getNiveauCourant().getSalleCourante().AddEvoluable(coeur);
        Partie.get().addICollision(coeur);  
        
        //Affiche le coeur au bon endroit
        translate(coeur.getCoordonnee().getX(),coeur.getCoordonnee().getY());
    }

    @Override
    public void Update(String message) {
        if(message.toLowerCase().equals("heal"))
        {
            soigner();
        }
    }
    
    /**
     * Méthode appelé quand le joueur passe sur le coeur. 
     * Il disparait de la vue et (TO DO) soigne le joueur
     */
    public void soigner(){   
        //Enlève le coeur de la liste des evoluables
        Partie.get().getNiveauCourant().getSalleCourante().RemoveEvoluable(coeur);
        //Et de la liste des collisions
        Partie.get().RemoveICollision(coeur);
        //Enlève la hitbox de l'affichage
        GamePane.get().removeView(this.hitboxCoeur);
        //Enlève la vue du coeur de l'image
        GamePane.get().removeView(this);
    }
    
}
