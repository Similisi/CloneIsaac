/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Controller;

/**
 * Interface représentant les Observeurs. Ce sont les vues qui souhaite être averti quand le model change.
 * @author Arnaud
 */
public interface Observeur {
    /**
     * Méthode, appelé lorsque le model change, avertissant la vue qu'elle doit mettre à jour ses informations.
     * @param message 
     */
    void Update(String message);
}
