/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.Metier.niveau.carte.Generateur;

/**
 * Classe représentant les cases de porte
 * @author Arnaud
 */
public class CasePorte extends Case{

    public CasePorte(int colonne, int ligne) {
        super(colonne, ligne);
    }

    @Override
    public TypeCase getType() {
        return TypeCase.PORTE;
    }

    @Override
    public String getSprite() {
        return "porte.png";
    }    
}
