/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Metier.niveau.carte.salle;

import java.util.ArrayList;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.ennemis.Ennemi;
import thebindingofalice.Metier.ennemis.volant.ChauveSouris;
import thebindingofalice.Metier.fabrique.FabriqueCase;
import thebindingofalice.Metier.niveau.carte.Generateur.TypeCase;
import thebindingofalice.Metier.objet.obstacle.Obstacle;
import thebindingofalice.Metier.objet.obstacle.ObstacleDestructible;
import thebindingofalice.Metier.objet.obstacle.Rocher;
import thebindingofalice.Metier.objet.ramassable.Cle;
import thebindingofalice.Metier.objet.ramassable.Coeur;
import thebindingofalice.Metier.objet.ramassable.ObjetRamassable;

/**
 * Classe, héritant de Salle, représentant une salle de base.
 * Cette classe sert de test. Elle ne sera peut être pas gardé par la suite.
 * @author Arnaud
 */
public class SalleSimple extends Salle{

    public SalleSimple() {
        super();
        //generateSalle();
    }
    
    /**
     * Méthode générant la salle
     */
    @Override
    public void generateSalle()
    {
        int tailleCote = Salle.getTailleCote();
        for (int i = 0; i < tailleCote; i++) {
            for (int j = 0; j < tailleCote; j++) {
                TypeCase type;
                if(i == 0 && j == 5 && (getVoisins().get(DirectionSalle.HAUT) != null) ||
                   i == tailleCote -1 && j == 5 && (getVoisins().get(DirectionSalle.BAS) != null) ||
                   i == 5 && j == 0 && (getVoisins().get(DirectionSalle.GAUCHE) != null)||
                   i == 5 && j == tailleCote -1 && (getVoisins().get(DirectionSalle.DROITE) != null))
                {
                    type = TypeCase.PORTE;
                }
                else if(i == 0 || i == tailleCote - 1 || j == 0 || j == tailleCote - 1)
                {
                    type = TypeCase.MUR;
                }
                else
                {
                    type = TypeCase.SOL;
                }
                AddCase(FabriqueCase.Create(type, j, i));
            }
        } 
        
    }
    
    @Override
    public TypeSalle getType() {
        return TypeSalle.Simple;
    }

    @Override
    public ArrayList<Ennemi> instanciateEnnemis() {
        ArrayList<Ennemi> ennemis = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            Coordonnee coord = new Coordonnee(500 + i * 200 , 300);
            ChauveSouris cS = new ChauveSouris(coord);
            ennemis.add(cS);
        }
        return ennemis;
    }

    @Override
    public ArrayList<ObjetRamassable> instanciateRamassable() {
        ArrayList<ObjetRamassable> objets = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Coordonnee coord = new Coordonnee(400 + i * 100 , 400);
            Cle cle = new Cle(coord);
            objets.add(cle);
        }
        
        for (int i = 0; i < 3; i++) {
            Coordonnee coor = new Coordonnee(300 + i * 100 , 500);
            Coeur c = new Coeur(coor);
            objets.add(c);
        }
        
        return objets;
    }

    @Override
    public ArrayList<Obstacle> instanciateObstacle() {
        ArrayList<Obstacle> ob = new ArrayList<>();
        Rocher rocher = new Rocher(new Coordonnee(600, 200));
        ob.add(rocher);
        
        ObstacleDestructible o = new ObstacleDestructible(new Coordonnee(600, 500));
        ob.add(o);
        
        return ob;
    }
}
