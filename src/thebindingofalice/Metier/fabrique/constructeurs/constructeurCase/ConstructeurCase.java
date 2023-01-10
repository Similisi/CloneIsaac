package thebindingofalice.Metier.fabrique.constructeurs.constructeurCase;

import thebindingofalice.Metier.niveau.carte.Generateur.Case;

/**
 * Interface représentant les différents  Constructeur pour les types de cases.
 * @author Arnaud
 */
public interface ConstructeurCase {

        /**
         * Méthode créeant une case
         * @param colonne la colonne de la case
         * @param ligne la ligne de la case
         * @return la case
         */
	public Case Create(int colonne, int ligne);
}