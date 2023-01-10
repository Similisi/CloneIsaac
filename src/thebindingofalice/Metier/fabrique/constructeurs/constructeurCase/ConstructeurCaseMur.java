/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Metier.fabrique.constructeurs.constructeurCase;

import thebindingofalice.Metier.niveau.carte.Generateur.Case;
import thebindingofalice.Metier.niveau.carte.Generateur.CaseMur;

/**
 * Constructeur des cases murs
 * @author Arnaud
 */
public class ConstructeurCaseMur implements ConstructeurCase{

    @Override
    public Case Create(int colonne, int ligne) {
        return new CaseMur(colonne, ligne);
    }    
}
