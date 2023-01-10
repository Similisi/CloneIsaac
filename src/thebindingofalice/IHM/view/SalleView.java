/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM.view;

import java.util.ArrayList;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import thebindingofalice.Controller.Observeur;
import thebindingofalice.IHM.GamePane;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.ennemis.Ennemi;
import thebindingofalice.Metier.ennemis.volant.ChauveSouris;
import thebindingofalice.Metier.niveau.carte.Generateur.Case;
import thebindingofalice.Metier.niveau.carte.Generateur.TypeCase;
import thebindingofalice.Metier.niveau.carte.salle.Salle;
import thebindingofalice.Metier.objet.Bombe;
import thebindingofalice.Metier.objet.obstacle.Obstacle;
import thebindingofalice.Metier.objet.obstacle.ObstacleDestructible;
import thebindingofalice.Metier.objet.obstacle.Porte;
import thebindingofalice.Metier.objet.obstacle.Rocher;
import thebindingofalice.Metier.objet.ramassable.Cle;
import thebindingofalice.Metier.objet.ramassable.Coeur;
import thebindingofalice.Metier.objet.ramassable.ObjetRamassable;

/**
 * Classe représentant la Observateur de la salle. C'est lui qui gère l'affichage des salles.
 * @author Arnaud
 */
public class SalleView implements Observeur{

    private Salle salle;
    private final AnchorPane background;

    public SalleView(AnchorPane back) {
        background = back;  
        Partie.get().getNiveauCourant().getCarte().Register(this);
        displaySalle();
    }   
    
    @Override
    public void Update(String message) {
        switch(message.toLowerCase())
        {
            case "changesallecourante" : displaySalle(); break;
            case "loot" : InstanciateLoot(); System.out.println("loot");break;
            case "addjoueur" : addJoueur(); break;
        }
    }
    
    /**
     * Méthode permettant d'afficher la salle en court.
     */
    private void displaySalle()
    {
        clearBeforeChangeRoom();
        salle = Partie.get().getNiveauCourant().getSalleCourante();
        salle.RegisterOnce(this);
        salle.clearEvoluables();
        salle.addJoueur();        
        if(!salle.isFinished())
        {
            instancierEnnemis();
            instancierRamassables();
            instancierObstacles();
        }
        int size = 60;
        for (Case c : salle.getCases()) {
            ImageView img = new ImageView(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Salle/" + c.getSprite());
            int x = 200 + c.getColonne() * size;
            int y = 20 + c.getLigne() * size;
            img.setX(x);
            img.setY(y);
            img.setFitHeight(size);
            img.setFitWidth(size);
            background.getChildren().add(img);
            if (c.getType() == TypeCase.MUR) {
                MurView mur = new MurView(new Coordonnee(x, y));
                GamePane.get().addView(mur);
            }
            else if (c.getType() == TypeCase.PORTE) {
                PorteView porteView = new PorteView(new Coordonnee(x, y),c.getColonne(),c.getLigne());
                Porte porte = porteView.getPorte();
                porte.setSalleNext(salle.getVoisins().get(porte.getDirection()));
                GamePane.get().addView(porteView);
            }
        }
    }  
    
    private void clearBeforeChangeRoom()
    {
        if(salle != null)
        {
            salle.clearEvoluables();    //clear les objets de la première salle
            salle.clearCases();
        }
        background.getChildren().clear();
        Partie.get().clearCollisions();
        GamePane.get().clear(); //On met cette opération en dernier car elle appel le garbage collector
    }

    private void InstanciateLoot() {
        GamePane gamePane = GamePane.get();
        CléView cle = new CléView(new Cle(new Coordonnee(350, 200)));
        gamePane.addView(cle);
    }

    /**
     * Méthode permettant d'instancier les ennemis
     */
    private void instancierEnnemis(){
        ArrayList<Ennemi> instanciateEnnemis = salle.instanciateEnnemis();
        for(Ennemi e : instanciateEnnemis)
        {
            View view;
            switch(e.getType()){
                case CHAUVE_SOURIS:
                    view = new ChauveSourisView((ChauveSouris) e);
                    break;
                default:
                    throw new AssertionError(e.getType().name());
                
            }
            GamePane.get().addView(view);
        }
    }
    
    private void instancierRamassables()
    {
        ArrayList<ObjetRamassable> instanciateRamassable = salle.instanciateRamassable();
        for(ObjetRamassable o : instanciateRamassable)
        {
            View view;
            switch(o.getType()){
                case COEUR: view = new CoeurView((Coeur) o); break;
                case CLE: view = new CléView((Cle) o); break;
                default:
                    throw new AssertionError(o.getType().name());
                
            }
            GamePane.get().addView(view);
        }
    }

    private void instancierObstacles() {
        ArrayList<Obstacle> instanciateObstacle = salle.instanciateObstacle();
        for(Obstacle o : instanciateObstacle)
        {
            View view;
            switch(o.getType()){
                case ROCHER: view = new RocherView((Rocher) o);
                    break;
                case BOMBE: view = new BombeView((Bombe) o); break;
                case OBSDESC: view = new TeapotView((ObstacleDestructible) o); break;
                default:
                    throw new AssertionError(o.getType().name());
                
                
            }
            GamePane.get().addView(view);
        }
    }

    private void addJoueur() {
        GamePane.get().addView(new JoueurView());
    }
    
    
    
}
