package thebindingofalice.IHM.view;

import javafx.scene.paint.Color;
import thebindingofalice.Controller.Observeur;
import thebindingofalice.IHM.GamePane;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.niveau.carte.Generateur.CaseMur;
import thebindingofalice.Metier.objet.obstacle.Mur;

/**
 * Classe IHM représentant les obstacles "Mur"
 * @author Arnaud
 */
public class MurView extends View implements Observeur{
    private final Mur mur;
    private final HitboxView hitboxMur;
    
    public MurView(Coordonnee coordonnee) {
        super(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Salle/mur.png");
        mur = new Mur(coordonnee); 
        setFitHeight(60);
        setFitWidth(60); 
        
        hitboxMur = new HitboxView(mur.getHitbox());
        //ligne à commenter si on veut rendre l'hitbox du mur transparente
        //hitboxMur.setStroke(Color.RED);
        //Rajoute la hitbox du mur sur l'affichage
        GamePane.get().addView(hitboxMur);
        
        //Ajout du mur à la liste des evoluables et des collisions
        Partie.get().getNiveauCourant().getSalleCourante().AddEvoluable(mur);
        Partie.get().addICollision(mur);
    }

    @Override
    public void Update(String message) {
        if(message.equals("mur"))
        {
            
        }
    }

    public Mur getMur() {
        return mur;
    }
    
}
