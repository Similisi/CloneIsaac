/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Metier.niveau.algoNiveau;

import java.util.ArrayList;
import thebindingofalice.Metier.niveau.Niveau;

/**
 * Classe provisoire, héritant de AlgoCreationNiveaux, renvoyant un niveau unique.
 * @author Arnaud
 */
public class MockAlgoNiveaux implements AlgoCreationNiveaux{

    @Override
    public ArrayList<Niveau> getNiveaux() {
        ArrayList<Niveau> niveaux = new ArrayList<>();
        
        Niveau n = new Niveau();
        niveaux.add(n);
        
        return niveaux;
    }
    
}
