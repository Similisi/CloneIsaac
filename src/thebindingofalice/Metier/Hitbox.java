package thebindingofalice.Metier;

import thebindingofalice.Controller.Observable;


/**
 * Classe représentant les hitbox des ICollision.
 * Les hitbox sont modélisé en rectangle.
 * @author Arnaud 
 */
public class Hitbox extends Observable{
    private double x;                   //position en X du point en haut à gauche de la hitbox
    private double y;                   //position en Y du poin en haut à gauche de la hitbox
    private final double height;        //hauteur de la hitbox
    private final double width;         //largeur de la hitbox
    
    public Hitbox(double x, double y, double height, double width) {
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }
    
    /**
     * Méthode permettant d'actualiser la position de la hitbox.
     * @param coordonnee coordonnee de l'objet.
     * @param plusX déplacement en X de la hitbox 
     * @param plusY déplacement en y de la hitbox
     */
    public void setPosition(Coordonnee coordonnee, double plusX, double plusY)
    {
        x = coordonnee.getX() + plusX;
        y = coordonnee.getY() + plusY;
        Notify("hitbox");
    }
    
    /**
     * Méthode permettant de detecter si deux hitbox se touchent
     * @param h l'autre hitbox
     * @return vrai si les deux hitbox se touchent, faux sinon.
     */
    public boolean isCollide(Hitbox h)
    {
        boolean touche = false;
        
        if((x >= h.x && x <= h.getX2() &&               //coin haut droite
            y >= h.y && y <= h.getY2()) ||
           (getX2() >= h.x && getX2() <= h.getX2() &&   //coin HautGauche      
            y >= h.y && y <= h.getY2()) ||
            getY2() >= h.y && getY2() <= h.getY2() &&   //Coin bas droite
            x >= h.x && x <= h.getX2()  ||
            getY2() >= h.y && getY2() <= h.getY2() &&   //Coin bas gauche
            getX2() >= h.x && getX2() <= h.getX2())
        {
            touche = true;
        }
        
        return touche;
    }
    
    private double getX2()
    {
        return x + width;
    }
    
    private double getY2()
    {
        return y + height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    /**
     * Méthode renvoyant le centre de la hitbox sur l'axe X.
     * @return Le centre de la hitbox sur l'axe X.
     */
    public double getXCenter()
    {
        return x + (width / 2);
    }
    
    /**
     * Méthode renvoyant le centre de la hitbox sur l'axe Y.
     * @return Le centre de la hitbox sur l'axe Y.
     */
    public double getYCenter()
    {
        return y + (height / 2);
    }
    
    /**
     * Méthode renvoyant la coordonnée du centre de la hitbox.
     * @return le centre de la hitbox.
     */
    public Coordonnee getCenter()
    {
        return new Coordonnee(getXCenter(), getYCenter());
    }
}
