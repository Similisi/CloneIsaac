/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM.view;

import javafx.scene.paint.Color;
import thebindingofalice.Controller.Observeur;
import thebindingofalice.IHM.GamePane;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.projectiles.ProjectileAllie;

/**
 *
 * @author johann
 * Classe IHM pour l'affichage d'un tir du joueur
 */
public class TirAllieView extends View implements Observeur{
    private final ProjectileAllie projectile;    
    private final HitboxView hitboxTir;
    
    public TirAllieView(ProjectileAllie p) {
        super(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Sprites/Tirs/Tir.png");
        this.projectile = p;
        projectile.Register(this);   
        
        hitboxTir= new HitboxView(p.getHitbox());
        //ligne à commenter si on veut rendre l'hitbox du tir transparente
        //hitboxTir.setStroke(Color.RED);
        //La ligne ci-dessous rajoute la hitbox du tir sur l'affichage
        GamePane.get().addView(hitboxTir);
        
        //Ajout du tir dans la liste des évoluables et des collisions de la partie
        Partie.get().getNiveauCourant().getSalleCourante().AddEvoluable(projectile);
        Partie.get().addICollision(projectile);
        
    }
    
    /**
     * Déplace le sprite du tir
     */
    private void moveSpriteTir()
    {
        //Récupérer les coordonnées du tir à l'appel de la méthode
        Coordonnee coordonnee = projectile.getCoordonnee();
        double x = coordonnee.getX();
        double y = coordonnee.getY();
        //Déplace le sprite
        translate(x, y);
    }
    @Override
    public void Update(String message) {
        switch(message.toLowerCase())
        {
            case "tirallie" : moveSpriteTir(); break;
            case "delete" : destroy(); break;
            default: break;
        }
    }
    
    /**
     * Détruit le tir et son sprite
     */
    public void destroy()
    {
        //Supprime le tir de la liste des évoluables et des collisions
        Partie.get().getNiveauCourant().getSalleCourante().RemoveEvoluable(projectile);
        Partie.get().RemoveICollision(projectile);
        //Supprime le sprite du tir et la vue de la hitbox de la vue principale
        GamePane.get().removeView(this.hitboxTir);
        GamePane.get().removeView(this);
    }
    
}
