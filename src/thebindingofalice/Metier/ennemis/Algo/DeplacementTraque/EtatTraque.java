/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Metier.ennemis.Algo.DeplacementTraque;

import java.util.Random;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.ennemis.Algo.Etat;
import thebindingofalice.Metier.ennemis.Ennemi;

/**
 *
 * @author johann
 */
public class EtatTraque extends Etat{
    
    private Ennemi ennemi;

    public EtatTraque(Ennemi ennemi) {
        this.ennemi = ennemi;
    }


    @Override
    public Etat Action() {
        Etat nouvelleEtat = this;
        if(Math.abs(this.ennemi.getCoordonnee().getX() - Partie.get().GetJoueur().getCoordonnee().getX()) <= 50 && Math.abs(this.ennemi.getCoordonnee().getY() - Partie.get().GetJoueur().getCoordonnee().getY()) <= 50)
        {
            Random random = new Random();
            int nb;
            nb = random.nextInt(2);
            if(nb == 0)
            {
                nouvelleEtat = new EtatRotationGauche(this.ennemi);

            }else
            {
                nouvelleEtat = new EtatRotationDroite(this.ennemi);
            }
        }else
        {
            nouvelleEtat = new EtatRepos(this.ennemi);
        
        }
        return nouvelleEtat;
    }

    @Override
    public String GetEtat() {
        return "traque";
    }
    
}
