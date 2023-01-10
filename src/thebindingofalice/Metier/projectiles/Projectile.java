package thebindingofalice.Metier.projectiles;

import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Evoluable;
import thebindingofalice.Metier.ICollision;

/**
 * Classe abstraite représentant les projectiles
 */
public abstract class Projectile extends Evoluable implements ICollision {
    private int vitesse;
    private DirectionTir dir;

    protected Projectile(Coordonnee coordonnee, DirectionTir dir) {
            super(coordonnee);
            this.dir = dir;
    }

    public abstract TypeProjectile getType();
}