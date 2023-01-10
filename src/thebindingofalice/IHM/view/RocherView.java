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
import thebindingofalice.Metier.objet.obstacle.Rocher;

/**
 *
 * @author Guillaume
 */
public class RocherView extends View implements Observeur{
    private final Rocher rocher;
    private final HitboxView hitboxRocher;

    public RocherView(Rocher r) {
        super(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Sprites/Rocher.png");
        this.rocher = r;
        setFitHeight(60);
        setFitWidth(60); 
        rocher.Register(this);
        
        hitboxRocher = new HitboxView(r.getHitbox());
        //hitboxRocher.setStroke(Color.RED);
        GamePane.get().addView(hitboxRocher);
        
        Partie.get().getNiveauCourant().getSalleCourante().AddEvoluable(rocher);
        Partie.get().addICollision(rocher);  
        
        
        translate(rocher.getCoordonnee().getX(),rocher.getCoordonnee().getY());
    }

    @Override
    public void Update(String message) {

    }
    
}
