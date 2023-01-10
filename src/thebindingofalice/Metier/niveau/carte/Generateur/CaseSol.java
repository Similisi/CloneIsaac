package thebindingofalice.Metier.niveau.carte.Generateur;

/**
 * Classe, héritant de Case, représentant le sol
 * @author Arnaud
 */
public class CaseSol extends Case {

    public CaseSol(int colonne, int ligne) {
        super(colonne, ligne);
    }    

    @Override
    public TypeCase getType() {
        return TypeCase.SOL;
    }

    @Override
    public String getSprite() {
        return "caseSol.png";
    }
    
    
}