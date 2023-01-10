/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM.view;

import thebindingofalice.Controller.Observeur;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.objet.HUD.CoeurHUDDroit;
import thebindingofalice.Metier.objet.HUD.CoeurHUDGauche;

/**
 *
 * @author johann
 */
public class CoeurHUDGaucheView extends View implements Observeur{
    
    private CoeurHUDGauche coeur;

    public CoeurHUDGaucheView(CoeurHUDGauche coeur) {
        super(System.getProperty("user.dir") + "/src/thebindingofalice/Images/HUD/CoeurGauche.png");
        this.coeur = coeur;
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
