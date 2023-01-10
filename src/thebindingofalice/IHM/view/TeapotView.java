/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM.view;

import javafx.scene.image.Image;
import thebindingofalice.Controller.Observeur;
import thebindingofalice.IHM.GamePane;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.objet.obstacle.ObstacleDestructible;

/**
 *
 * @author Guillaume
 */
public class TeapotView extends View implements Observeur{
    private final ObstacleDestructible obstacle;
    private final HitboxView hitboxObstacle;

    public TeapotView(ObstacleDestructible r) {
        super(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Sprites/teapot_intact.png");
        this.obstacle = r;
        setFitHeight(60);
        setFitWidth(60); 
        obstacle.Register(this);
        
        hitboxObstacle = new HitboxView(r.getHitbox());
        //hitboxRocher.setStroke(Color.RED);
        GamePane.get().addView(hitboxObstacle);
        
        Partie.get().getNiveauCourant().getSalleCourante().AddEvoluable(obstacle);
        Partie.get().addICollision(obstacle);  
        
        
        translate(obstacle.getCoordonnee().getX(),obstacle.getCoordonnee().getY());
    }

    @Override
    public void Update(String message) {
        if(message.toLowerCase().equals("touche"))
        {
            //Si l'obstacle s'est fait touché une fois on change le sprite
            if(this.obstacle.getHP()==75){
                Image img = new Image(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Sprites/teapot_slightly_damaged.png");
                this.setImage(img);
            }
            //Si il s'est fait touché trois fois on change le sprite
            else if(this.obstacle.getHP()==25){
                Image img = new Image(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Sprites/teapot_damaged.png");
                this.setImage(img);
            }
            //Si il s'est fait touche quatre fois on le détruit
            else if(this.obstacle.getHP()<=0){
                destroy();
            }
            
        }
    }
    
    public void destroy(){
        //Enlève l'obstacle de la liste des evoluables
        Partie.get().getNiveauCourant().getSalleCourante().RemoveEvoluable(obstacle);
        //Et de la liste des collisions
        Partie.get().RemoveICollision(obstacle);
        //Enlève la hitbox de l'affichage
        GamePane.get().removeView(this.hitboxObstacle);
        //Enlève la vue de l'obstacle de l'image
        GamePane.get().removeView(this);
    }
    
}
