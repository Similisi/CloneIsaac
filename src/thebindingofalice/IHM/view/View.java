/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM.view;

import javafx.scene.image.ImageView;

/**
 * Classe abstraite représentant les vues. Elles sont hérités d'image View
 * @author Arnaud
 */
public abstract class View extends ImageView{

    public View(String string) {
        super(string);
    }    
    
    /**
     * Déplace la vue 
     * @param x déplacement sur les abscisses
     * @param y et les ordonnées
     */
    protected void translate(double x, double y)
    {
        setTranslateX(x);
        setTranslateY(y);
    }
}
