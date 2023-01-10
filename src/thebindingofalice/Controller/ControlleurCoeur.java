/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Controller;

import thebindingofalice.Metier.objet.ramassable.Coeur;

/**
 * Controller et observable des objet de type coeur
 * @author Pascaline
 */
public class ControlleurCoeur extends Observable{
    
    private final Coeur coeur;

    public ControlleurCoeur(Coeur coeur) {
        this.coeur = coeur;
    }
}
