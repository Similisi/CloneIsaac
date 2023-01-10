package thebindingofalice.Metier.niveau.carte.Generateur;

/**
 * Classe abstraite représentant les cases qui composent les pièces.
 * @author Arnaud
 */
public abstract class Case {
	private final int ligne;            //ligne de la case
	private final int colonne;          //colonne de la case
        
	protected Case(int colonne, int ligne) {
		this.ligne = ligne;
                this.colonne = colonne;
	}

        /**
         * Accesseur de la ligne de la case
         * @return la ligne de la case
         */
        public int getLigne() { return ligne; }
        
        /**
         * Accesseur de la colonne de la case
         * @return la colonne de la case
         */
        public int getColonne() { return colonne; }
        
        /**
         * Accesseur du type de la case
         * @return le type de la case
         */
	public abstract TypeCase getType();
        
        /**
         * Accesseur du sprite de la case
         * @return le sprite de la case
         */
        public abstract String getSprite();
}