/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM.view;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import thebindingofalice.Controller.Observeur;
import thebindingofalice.IHM.GamePane;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.niveau.carte.salle.DirectionSalle;
import thebindingofalice.Metier.niveau.carte.salle.Salle;
import thebindingofalice.Metier.objet.obstacle.Porte;

/**
 *
 * @author Pascaline
 */
public class PorteView extends View implements Observeur{
    private final Porte porte;
    private final HitboxView hitboxPorte;
    private String typePorte;

    public PorteView(Coordonnee coordonnee,int colonne, int ligne) {
        super(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Salle/porte.png");
        String sprite = "casePorte.png";
        DirectionSalle dir = null;
        int tailleCote = Salle.getTailleCote();
        if(colonne == 0)
        {
            this.typePorte = "porteGauche";
            sprite = "porteGauche.png";
            dir = DirectionSalle.GAUCHE;
        }
        else if (colonne == tailleCote -1)
        {
            this.typePorte = "porteDroite";
            sprite = "porteDroite.png";
            dir = DirectionSalle.DROITE;
        }
        else if (ligne == 0)
        {
            this.typePorte = "porte";
            sprite = "porte.png";
            dir = DirectionSalle.HAUT;
        }
        else if(ligne == tailleCote -1)
        {
            this.typePorte = "porteBas";
            sprite = "porteBas.png";
            dir = DirectionSalle.BAS;
        }
        Image imageporte = new Image(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Salle/"+sprite);
        this.setImage(imageporte);
        porte = new Porte(coordonnee, dir); 
        porte.Register(this);
        setFitHeight(60);
        setFitWidth(60);
        
        hitboxPorte = new HitboxView(porte.getHitbox());
        //ligne à commenter si on veut rendre l'hitbox du mur transparente
        //hitboxPorte.setStroke(Color.RED);
        //Rajoute la hitbox du mur sur l'affichage
        GamePane.get().addView(hitboxPorte);
        
        //Ajout du mur à la liste des evoluables et des collisions
        Partie.get().getNiveauCourant().getSalleCourante().AddEvoluable(porte);
        Partie.get().addICollision(porte);
        
        translate(porte.getCoordonnee().getX(),porte.getCoordonnee().getY());
    }

    @Override
    public void Update(String message) {
        if(message.toLowerCase().equals("ouvert"))
        {
            this.porte.setOuvert(true);
            Image porteOuv = new Image (System.getProperty("user.dir") + "/src/thebindingofalice/Images/Salle/"+this.typePorte+"Ouverte.png");
            this.setImage(porteOuv);
        }
        
    }

    public Porte getPorte() {
        return porte;
    }   
    
}