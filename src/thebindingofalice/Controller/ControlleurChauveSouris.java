/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Controller;

import thebindingofalice.Metier.ennemis.volant.ChauveSouris;


/**
 *
 * @author Pascaline
 */
public class ControlleurChauveSouris extends Observable{
    /*
    *Joueur "controllé"
    */
    private final ChauveSouris chauveSouris;

    public ControlleurChauveSouris(ChauveSouris cS) {
        this.chauveSouris = cS;
    }
    
}
