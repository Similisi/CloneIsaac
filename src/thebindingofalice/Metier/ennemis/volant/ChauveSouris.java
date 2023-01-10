package thebindingofalice.Metier.ennemis.volant;

import java.util.Random;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Hitbox;
import thebindingofalice.Metier.ICollision;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.ennemis.Algo.DeplacementTraque.EtatRepos;
import thebindingofalice.Metier.ennemis.Algo.Etat;
import thebindingofalice.Metier.ennemis.TypeEnnemi;
import thebindingofalice.Metier.niveau.carte.salle.Salle;

/**
 * Classe ,héritant de Ennemi Volant, représentant les chauves souris
 */
public class ChauveSouris extends EnnemiVolant {    
    //Hitbox de l'ennemi
    private final Hitbox hitbox;
    
    private int frame = 20;
    
    private int framedeplacement = 60;
    
    private Etat etatDeplacement;
    
    private boolean changementEtat = true;
    
    public ChauveSouris(Coordonnee c) {
        super(c);
        hitbox = new Hitbox(c.getX(), c.getY(), 27, 36);
        this.etatDeplacement = new EtatRepos(this);
    }

    /**
     * Méthode appelé à chaque frame du jeu. Le paramètre pas représente le pas
     * de temps entre deux appel de la méthode.
     */
    public void evoluer(double pas) {
        
        if(this.etatDeplacement.GetEtat() == "repos"){
            if(frame < 0)
            {
                Random r = new Random();
                int v = getStatistiques().getVitesseDeplacement();
                setVitesseX(r.nextInt()% v);
                setVitesseY(r.nextInt() % v);
                frame = 20;
            }
            frame--;
            this.etatDeplacement = this.etatDeplacement.Action();
            this.framedeplacement = 60;
        }else if(this.etatDeplacement.GetEtat() == "traque")
        {
            if(this.getCoordonnee().getX() < Partie.get().GetJoueur().getCoordonnee().getX())
            {
                setVitesseX(1);
            }
            
            if(this.getCoordonnee().getX() > Partie.get().GetJoueur().getCoordonnee().getX())
            {
                setVitesseX(-1);
            }
            
            if(this.getCoordonnee().getY() < Partie.get().GetJoueur().getCoordonnee().getY())
            {
                setVitesseY(1);
            }
            
            if(this.getCoordonnee().getX() > Partie.get().GetJoueur().getCoordonnee().getX())
            {
                setVitesseY(-1);
            }
            if(this.framedeplacement <= 0)
            {
                this.etatDeplacement = this.etatDeplacement.Action();
                this.framedeplacement = 60;
            }
            this.framedeplacement --;
        }else if(this.etatDeplacement.GetEtat() == "rotation gauche")
        {
            setVitesseX(-1);
            setVitesseY(1);
            if(this.framedeplacement <= 0)
            {
                this.etatDeplacement = this.etatDeplacement.Action();
                this.framedeplacement = 60;
            }
            this.framedeplacement --;
            
        }else if(this.etatDeplacement.GetEtat() == "rotation droite")
        {
            setVitesseX(1);
            setVitesseY(-1);
            if(this.framedeplacement <= 0)
            {
                this.etatDeplacement = this.etatDeplacement.Action();
                this.framedeplacement = 60;
            }
            this.framedeplacement --;
        }
        
        Coordonnee c = getCoordonnee();
        setCoordonnee(new Coordonnee(c.getX() + getVitesseX() * pas, c.getY() + getVitesseY() * pas));
        hitbox.setPosition(c, 0, 0);
        
        
        Notify("ChauveSourisDeplacement");
        
    }

    @Override
    public void Collision(ICollision o) {
        if (o.EstLeJoueur()) {
            Partie.get().GetJoueur().PrendDegat(1);
        }
        else if(o.estUnProjectileAllie())
        {
            mourir();
        }
    }

    private void mourir() {
        Notify("destroy");
    }
    
    public boolean EstLeJoueur() {
            return false;
    }
    @Override
    public boolean estUnProjectileAllie() {
        return false;
    }

    public boolean EstBloquant() {
            return false;
    }

    @Override
    public TypeEnnemi getType() {
        return TypeEnnemi.CHAUVE_SOURIS;
    }

    @Override
    public Hitbox getHitbox() {
        return hitbox;
    }
}