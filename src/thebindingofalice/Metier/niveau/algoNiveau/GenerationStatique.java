/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Metier.niveau.algoNiveau;

import java.util.ArrayList;
import thebindingofalice.Metier.niveau.Niveau;
import thebindingofalice.Metier.niveau.carte.salle.DirectionSalle;
import thebindingofalice.Metier.niveau.carte.salle.Salle;
import thebindingofalice.Metier.niveau.carte.salle.SalleSimple;

/**
 * Classe représentant un algorithme de création de niveau statique.
 * @author Arnaud
 */
public class GenerationStatique implements AlgoCreationNiveaux{

    @Override
    public ArrayList<Niveau> getNiveaux() {
        ArrayList<Niveau> niveaux = new ArrayList<>();
        
        niveaux.add(niveauStatique());
        
        return niveaux;
    }
    
    private Niveau niveauStatique()
    {
        Niveau niveau = new Niveau();
        
        ArrayList<Salle> salles = new ArrayList<>();
        for(int i = 0; i < 9; i++)
        {
            salles.add(new SalleSimple());
        }
        
        for(DirectionSalle d : DirectionSalle.values())
        {
            
            switch (d) {
                case HAUT:
                    salles.get(0).addVoisin(d, salles.get(1));
                    salles.get(1).addVoisin(DirectionSalle.BAS, salles.get(0));
                    break;
                case BAS:
                    salles.get(0).addVoisin(d, salles.get(2));
                    salles.get(2).addVoisin(DirectionSalle.HAUT, salles.get(0));
                    break;
                case GAUCHE:
                    salles.get(0).addVoisin(d, salles.get(3));
                    salles.get(3).addVoisin(DirectionSalle.DROITE, salles.get(0));
                    break;
                case DROITE:
                    salles.get(0).addVoisin(d, salles.get(4));
                    salles.get(4).addVoisin(DirectionSalle.GAUCHE, salles.get(0));
                    break;
                default:
                    throw new AssertionError(d.name());

            }
        }
        
        salles.get(1).addVoisin(DirectionSalle.GAUCHE, salles.get(5));
        salles.get(1).addVoisin(DirectionSalle.DROITE, salles.get(6));
        
        salles.get(2).addVoisin(DirectionSalle.GAUCHE, salles.get(7));
        salles.get(2).addVoisin(DirectionSalle.DROITE, salles.get(8));
        
        salles.get(3).addVoisin(DirectionSalle.HAUT, salles.get(5));
        salles.get(3).addVoisin(DirectionSalle.BAS, salles.get(7));
                
        salles.get(4).addVoisin(DirectionSalle.HAUT, salles.get(6));
        salles.get(4).addVoisin(DirectionSalle.BAS, salles.get(8));
        
        salles.get(5).addVoisin(DirectionSalle.BAS, salles.get(3));
        salles.get(5).addVoisin(DirectionSalle.DROITE, salles.get(1));
        
        salles.get(6).addVoisin(DirectionSalle.GAUCHE, salles.get(1));
        salles.get(6).addVoisin(DirectionSalle.BAS, salles.get(4));
        
        salles.get(7).addVoisin(DirectionSalle.HAUT, salles.get(3));
        salles.get(7).addVoisin(DirectionSalle.DROITE, salles.get(2));
        
        salles.get(8).addVoisin(DirectionSalle.GAUCHE, salles.get(2));
        salles.get(8).addVoisin(DirectionSalle.HAUT, salles.get(4));        
        
        niveau.getCarte().setSalles(salles);
        
        return niveau;
    }
    
}
