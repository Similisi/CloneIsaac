/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM.view;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import thebindingofalice.Controller.Observeur;
import thebindingofalice.IHM.GamePane;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.objet.Bombe;

/**
 *
 * @author noaba
 */
public class BombeView extends View implements Observeur{
    //bombe représentée
    private final Bombe bombe;
    //Vue de la hitbox de la bombe représentée à afficher
    private HitboxView hitboxBombe;
    //timer pour laisser la hitbox de la bombe assez longtemps à l'écran pour qu'elle puisse faire des dégats aux éléments autour
    private AnimationTimer explTimer;
    
    //Compteur à décrémenter pour arrêter le timer et détruire la bombe
    private int tempoExpl=100;
    /**
     * Constructeur de l'affichage de la bombe
     * @param b la bombe qu'on veut afficherr
     */
    public BombeView(Bombe b) {
        //On passe en paramètre le sprite de la bombe
        super(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Sprites/bomb1.png");
        this.bombe = b;
        //La bombe est observée par la vue
        bombe.Register(this);
        
        //ajoute la bombe à liste des evoluable et des collisions de la partie
        Partie.get().getNiveauCourant().getSalleCourante().AddEvoluable(bombe);
        Partie.get().addICollision(bombe);  
        
        //Affiche la bombe au bon endroit
        translate(bombe.getCoordonnee().getX(),bombe.getCoordonnee().getY());
    }

    @Override
    public void Update(String message) {
        if(message.toLowerCase().equals("explosion"))
        {
            //On change le sprite de la bombe
            Image img = new Image(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Sprites/bomb3.png");
            this.setImage(img);
            this.translate(this.bombe.getCoordonnee().getX()-20, this.bombe.getCoordonnee().getY()-20);
            hitboxBombe = new HitboxView(this.bombe.getHitbox());
            //change la couleur du contour de la hitbox (à commenter pour laisser transparent)
            //hitboxBombe.setStroke(Color.RED);
            //ajoute la hitbox de la bombe sur l'affichage
            GamePane.get().addView(hitboxBombe);
            explTimer = new AnimationTimer()
            {
                @Override
                public void handle(long pas) {      
                    tempoExpl -=1 ;
                }            
            };
            explTimer.start();
            if(tempoExpl<=0){
                explTimer.stop();
                exploser();
            }
        }
    }
    
    /**
     * Méthode appelé quand le joueur passe sur le coeur. 
     * Il disparait de la vue et (TO DO) soigne le joueur
     */
    public void exploser(){   
        //Enlève la bombe de la liste des evoluables
        Partie.get().getNiveauCourant().getSalleCourante().RemoveEvoluable(bombe);
        //Et de la liste des collisions
        Partie.get().RemoveICollision(bombe);
        //Enlève la hitbox de l'affichage
        GamePane.get().removeView(this.hitboxBombe);
        //Enlève la vue de la bombe de l'image
        GamePane.get().removeView(this);
    }
}
