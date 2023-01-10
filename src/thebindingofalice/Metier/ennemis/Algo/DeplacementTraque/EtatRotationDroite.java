/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Metier.ennemis.Algo.DeplacementTraque;

import java.util.Random;
import thebindingofalice.Metier.ennemis.Algo.Etat;
import thebindingofalice.Metier.ennemis.Ennemi;

/**
 *
 * @author johann
 */
public class EtatRotationDroite extends Etat{

    private Ennemi ennemi;
    
    EtatRotationDroite(Ennemi ennemi) {
        this.ennemi = ennemi;
    }

    @Override
    public Etat Action() {
        Etat nouvelleEtat = this;
        Random random = new Random();
        int nb;
        nb = random.nextInt(2);
        if(nb == 0)
        {
            nouvelleEtat = new EtatTraque(this.ennemi);

        }else
        {
            nouvelleEtat = new EtatRotationGauche(this.ennemi);
        }
        
        return nouvelleEtat;
    
    }

    @Override
    public String GetEtat() {
        return "rotation droite";
    }
    
}
