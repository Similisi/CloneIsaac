/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import thebindingofalice.Main;

/**
 * FXML Controller class
 * Classe IHM qui est le menu principal du jeu
 * @author Pascaline
 */
public class MenuGameOverView implements Initializable {
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    /**
     * Lance le jeu en changeant la fenêtre afficher
     */
    public void MCJouer(MouseEvent event){
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("EnJeu.fxml"));
            Stage stage = Main.getPrimaryStage();
            stage.setX(200);
            stage.setY(1);
            stage.setScene(new Scene(root, 1000, 700));
            root.requestFocus(); //I don't know why but this is necessary to keep event working
        } catch (IOException ex) {
            Logger.getLogger(MenuGameOverView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @FXML
    /**
     * Revenir au menu principal
     */
    public void MCMenuPrincipal(MouseEvent event){
        try { 
            Parent root = FXMLLoader.load(getClass().getResource("MenuPrincipal.fxml"));
            Stage stage = Main.getPrimaryStage();
            stage.setX(200);
            stage.setY(1);
            stage.setScene(new Scene(root, 800.0, 453.0));
            root.requestFocus(); //I don't know why but this is necessary to keep event working
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    /**
     * Quitte le jeu
     */
    public void MCQuitter(MouseEvent event){
        Main.getPrimaryStage().close();
    }
}
