package thebindingofalice.Metier;
/**
 * Classe représentant des coordonnées 2D. Elle compose tout objet qui doit "évoluer a chaque frame".
 */
public class Coordonnee {
    private double x;
    private double y;

    public Coordonnee(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Coordonnee(Coordonnee coordonnee) {
        this.x = coordonnee.x;
        this.y = coordonnee.y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    
    
    
}