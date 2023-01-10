package thebindingofalice.Metier.fabrique.constructeurs;

import thebindingofalice.Metier.projectiles.Projectile;

/**
 * Interface représentant les différents  Constructeur pour les types de projectiles.
 */
public interface ConstructeurProjectile {

	public Projectile Create();
}