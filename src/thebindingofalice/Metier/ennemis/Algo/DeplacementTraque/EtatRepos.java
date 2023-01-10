/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Metier.ennemis.Algo.DeplacementTraque;

import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.ennemis.Algo.Etat;
import thebindingofalice.Metier.ennemis.Ennemi;

/**
 *
 * @author johann
 */
public class EtatRepos extends Etat{
    private Ennemi ennemi;
    
    public EtatRepos(Ennemi e) {
        this.ennemi = e;
    }

    
    
    
    @Override
    public Etat Action() {
        Etat nouvelleEtat = this;
 
        if(Math.abs(this.ennemi.getCoordonnee().getX() - Partie.get().GetJoueur().getCoordonnee().getX()) <= 50 && Math.abs(this.ennemi.getCoordonnee().getY() - Partie.get().GetJoueur().getCoordonnee().getY()) <= 50)
        {
            nouvelleEtat = new EtatTraque(this.ennemi);
        }
        return nouvelleEtat;
    }

    @Override
    public String GetEtat() {
        return "repos";
    }
    
}
