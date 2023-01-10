package thebindingofalice.Metier.projectiles;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Hitbox;
import thebindingofalice.Metier.ICollision;

/**
 * Classe, héritant de Projectile, représentant les projectiles alliés
 */
public class ProjectileAllie extends Projectile {
    
    private Hitbox hitbox;
    
    private DirectionTir dirTir;
    
    private float vitesse = 5f;

    public ProjectileAllie(Coordonnee coordonnee, DirectionTir dir) {
        super(coordonnee, dir);
        this.hitbox = new Hitbox(coordonnee.getX(),coordonnee.getY(),16,16);
        this.dirTir = dir;      
    }

    /**
     * /**
     *  * Méthode appelé à chaque frame du jeu. Le paramètre pas représente le pas de temps entre deux appel de la méthode.
     *  * /
     */
    @Override
    public void evoluer(double pas) {
           Coordonnee c = getCoordonnee();
           switch (dirTir)
           {
               case HAUT:
                   setCoordonnee(new Coordonnee(c.getX(), c.getY() - vitesse * pas));
                   break;
               case BAS:
                   setCoordonnee(new Coordonnee(c.getX(), c.getY() + vitesse * pas));                   
                   break;
               case GAUCHE:
                   setCoordonnee(new Coordonnee(c.getX() - vitesse * pas, c.getY()));
                   break;
               case DROITE:
                   setCoordonnee(new Coordonnee(c.getX() + vitesse * pas, c.getY()));
                   break;
           
           }
           
           hitbox.setPosition(c, 1, 0);
           Notify("tirallie"); 
    }

    @Override
    public void Collision(ICollision o) {
        if(o.EstBloquant())
        {
            Notify("delete");
        }
    }

    @Override
    public boolean EstLeJoueur() {
        return false;
    }

    @Override
    public boolean EstBloquant() {
        return false;
    }

    @Override
    public TypeProjectile getType() {
        return TypeProjectile.ProjectileAllie;
    }

    @Override
    public Hitbox getHitbox() {
        return hitbox;
    }

    public float getVitesse() {
        return vitesse;
    }

    public void setVitesse(float vitesse) {
        this.vitesse = vitesse;
    }

    @Override
    public boolean estUnProjectileAllie() {
        return true;
    }
}