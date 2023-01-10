package thebindingofalice.Metier.niveau.carte.Generateur;

/**
 * Classe, héritant de Case, représentant les cases de vide
 * @author Arnaud
 */
public class CaseVide extends Case {

    public CaseVide(int colonne, int ligne) {
        super(colonne, ligne);
    }    

    @Override
    public TypeCase getType() {
        return TypeCase.VIDE;
    }

    @Override
    public String getSprite() {
        return "";
    }
    
}