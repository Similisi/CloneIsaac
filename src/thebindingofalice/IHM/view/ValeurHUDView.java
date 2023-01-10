/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import thebindingofalice.Controller.Observeur;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.objet.HUD.ValeurHUD;

/**
 *
 * @author johann
 */
public class ValeurHUDView extends View implements Observeur{
    //valeur qu'il affiche
    private int valeur;
    //objet valeur
    private ValeurHUD objVal;
    
    public ValeurHUDView(ValeurHUD val) {
        super(System.getProperty("user.dir") + "/src/thebindingofalice/Images/HUD/valeur/0.png");
        this.valeur = 0;
        this.objVal = val;
        Coordonnee coordonnee = this.objVal.getCoordonnee();
        double x = coordonnee.getX();
        double y = coordonnee.getY();
        //System.out.println("x" + x + " | y" + y);
        translate(x, y);
    }

    @Override
    public void Update(String message) {
        
    }
    
    public void changeValeur(int valeur) throws FileNotFoundException
    {
        FileInputStream input;
        
        switch (valeur)
        {
            case 1:
                input = new FileInputStream(System.getProperty("user.dir") + "/src/thebindingofalice/Images/HUD/valeur/1.png");
            break;
            case 2:
                input = new FileInputStream(System.getProperty("user.dir") + "/src/thebindingofalice/Images/HUD/valeur/2.png");
            break;
            case 3:
                input = new FileInputStream(System.getProperty("user.dir") + "/src/thebindingofalice/Images/HUD/valeur/3.png");
            break;
            case 4:
                input = new FileInputStream(System.getProperty("user.dir") + "/src/thebindingofalice/Images/HUD/valeur/4.png");
            break;
            case 5:
                input = new FileInputStream(System.getProperty("user.dir") + "/src/thebindingofalice/Images/HUD/valeur/5.png");
            break;
            case 6:
                input = new FileInputStream(System.getProperty("user.dir") + "/src/thebindingofalice/Images/HUD/valeur/6.png");
            break;
            case 7:
                input = new FileInputStream(System.getProperty("user.dir") + "/src/thebindingofalice/Images/HUD/valeur/7.png");
            break;
            case 8:
                input = new FileInputStream(System.getProperty("user.dir") + "/src/thebindingofalice/Images/HUD/valeur/8.png");
            break;
            case 9:
                input = new FileInputStream(System.getProperty("user.dir") + "/src/thebindingofalice/Images/HUD/valeur/9.png");
            break;
            default:
                input = new FileInputStream(System.getProperty("user.dir") + "/src/thebindingofalice/Images/HUD/valeur/0.png");
                break;
            
        }
        this.setImage(new Image(input));
        this.valeur = valeur;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
    
    
    
    
}
