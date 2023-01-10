/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Noa BARBOSA
 * Classe représentant la fenêtre du jeu contient toutes les autres vue dans son premier plan
 * La classe est un singleton pour faciliter l'ajout des vues
 */
public class GamePane{
    private static GamePane instance = null;
    //Premier plan de la fenêtre qui contient toutes les vues 
    private final AnchorPane foreground;
    
    /**
     * Constructeur de la fenêtre
     */
    private GamePane(){ 
        foreground= new AnchorPane();
    }
    
    /**
     * Assesseur de la fenêtre
     * @return la fenêtre
     */
    public static GamePane get() {
        if (instance == null) {
            instance = new GamePane();
        }
        return instance;
    }

    /**
     * Ajoute un élément au premier plan de la fenêtre
     * @param n élément à ajouter (peut être tout objet Node)
     */
    public void addView(Node n) {
        foreground.getChildren().add(n);
    }
    
    /**
     * Supprime un élément du premier plan
     * @param n élément à supprimer
     */
    public void removeView(Node n) {
        foreground.getChildren().remove(n);
    }

    /**
     * Assesseur du premier plan
     * @return le premier de la fenêtre
     */
    public AnchorPane getForeground(){
         return foreground;
     }
    
    
    public void clear() {
        foreground.getChildren().clear();
        System.gc();    //appel du garbage collector pour clean la mémoire
    }
}
