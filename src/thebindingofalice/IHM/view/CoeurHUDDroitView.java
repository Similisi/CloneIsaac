/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM.view;

import thebindingofalice.Controller.Observeur;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.objet.HUD.CoeurHUDDroit;

/**
 *
 * @author johann
 */
public class CoeurHUDDroitView extends View implements Observeur {
    private CoeurHUDDroit coeur;
    
    public CoeurHUDDroitView(CoeurHUDDroit coeur) {
        super(System.getProperty("user.dir") + "/src/thebindingofalice/Images/HUD/CoeurDroit.png");
        this.coeur = coeur;
        Coordonnee coordonnee = this.coeur.getCoordonnee();
        double x = coordonnee.getX();
        double y = coordonnee.getY();
        //System.out.println("x" + x + " | y" + y);
        translate(x, y);
    }

    @Override
    public void Update(String message) {
        
        
    }
    
    
    
}
