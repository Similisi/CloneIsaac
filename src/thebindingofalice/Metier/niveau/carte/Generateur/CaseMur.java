package thebindingofalice.Metier.niveau.carte.Generateur;

import thebindingofalice.Metier.niveau.carte.salle.Salle;

/**
 * Classe, héritant de Case, représentant les murs
 * @author Arnaud
 */
public class CaseMur extends Case {
    private String sprite;
    
    public CaseMur(int colonne, int ligne) {
        super(colonne, ligne);
        sprite = "caseMur.png";
        int tailleCote = Salle.getTailleCote();
        if(colonne == 0 && ligne == 0)
        {
            sprite = "murCoinHautGauche.png";
        }
        else if(colonne == 0 && ligne == tailleCote - 1)
        {
            sprite = "murCoinBasGauche.png";
        }
        else if(colonne == tailleCote -1 && ligne == 0)
        {
            sprite = "murCoinHautDroite.png";
        }
        else if(colonne == tailleCote -1 && ligne == tailleCote -1)
        {
            sprite = "murCoinBasDroite.png";
        }
        else if(colonne == 0)
        {
            sprite = "murGauche.png";
        }
        else if (colonne == tailleCote -1)
        {
            sprite = "murDroite.png";
        }
        else if (ligne == 0)
        {
            sprite = "murHaut.png";
        }
        else if(ligne == tailleCote -1)
        {
            sprite = "murBas.png";
        }
    }    

    @Override
    public TypeCase getType() {
        return TypeCase.MUR;
    }

    @Override
    public String getSprite() {
        return sprite;
    }
    
}