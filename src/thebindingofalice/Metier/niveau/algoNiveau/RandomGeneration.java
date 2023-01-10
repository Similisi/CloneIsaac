/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Metier.niveau.algoNiveau;

import java.util.ArrayList;
import java.util.Random;
import thebindingofalice.Metier.niveau.Niveau;
import thebindingofalice.Metier.niveau.carte.salle.Salle;
import thebindingofalice.Metier.niveau.carte.salle.SalleSimple;

/**
 *
 * @author Arnaud
 */
public class RandomGeneration implements AlgoCreationNiveaux{

    @Override
    public ArrayList<Niveau> getNiveaux() {
        ArrayList<Niveau> niveaux = new ArrayList<>();
        Niveau niveau = new Niveau();
        
        niveau.getCarte().setSalles(genAleatoire());
        
        niveaux.add(niveau);        
        return niveaux;
    }

    private ArrayList<Salle> genAleatoire() {
        ArrayList<Salle> salles = new ArrayList<>();
        int seed = 891256;
        for(int i = 10; i < 10; i++)
        {
            Salle salle = new SalleSimple();
            salles.add(salle);
        }       
        
        Random r = new Random(seed);
        
        return salles;
    }
    
}
