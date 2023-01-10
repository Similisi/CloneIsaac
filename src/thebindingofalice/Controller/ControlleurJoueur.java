/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Controller;

import thebindingofalice.Metier.joueur.DirectionDeplacement;
import thebindingofalice.Metier.joueur.Joueur;
import thebindingofalice.Metier.projectiles.DirectionTir;

/**
 *
 * @author Arnaud
 * Controlleur du joueur utilisé lors des inputs du joueur
 */
public class ControlleurJoueur extends Observable{
    /*
    *Joueur "controllé"
    */
    private final Joueur joueur;

    public ControlleurJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
    
    /**
     * Demande au joueur de bouger
     * @param dir dans la direction donné (soit HAUT,BAS,DROITE ou GAUCHE)
     */
    public void bouger(DirectionDeplacement dir)
    {
        joueur.Bouger(dir);
        
    }
    
    /**
     * Demande au joueur de s'arrêter
     * @param d dans la direction donnée
     */
    public void sArreter(DirectionDeplacement d)
    {
        joueur.sArreter(d);
    }
  
    /**
     * Demande au joueur de tirer
     * @param d dans la direction donné (soit HAUT,BAS,DROITE ou GAUCHE)
     */
    public void tirer(DirectionTir d)
    {
        joueur.Tirer(d);
    }

    /**
     * Demande au joueur d'arrêter de tirer
     * @param d dans la direction donnée
     */
    public void stopTirer(DirectionTir d){
        joueur.stopTirer(d);
    }

    public void poserBombe() {
        joueur.poserBombe();
    }
    
}
