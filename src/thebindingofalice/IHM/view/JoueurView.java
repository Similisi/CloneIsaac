/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebindingofalice.IHM.view;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import thebindingofalice.Controller.ControlleurJoueur;
import thebindingofalice.Controller.Observeur;
import thebindingofalice.IHM.GamePane;
import thebindingofalice.Metier.Coordonnee;
import thebindingofalice.Metier.Partie;
import thebindingofalice.Metier.joueur.DirectionDeplacement;
import thebindingofalice.Metier.joueur.Joueur;
import thebindingofalice.Metier.objet.HUD.CoeurHUDDroit;
import thebindingofalice.Metier.objet.HUD.CoeurHUDGauche;
import thebindingofalice.Metier.objet.HUD.ValeurHUD;
import thebindingofalice.Metier.objet.ramassable.Cle;
import thebindingofalice.Metier.objet.ramassable.TypeCoeur;
import thebindingofalice.Metier.projectiles.DirectionTir;

/**
 * Classe IHM représentant la vue du joueur.
 * @author Arnaud
 */
public class JoueurView extends View implements Observeur{
    //Joueur à afficher
    private final Joueur joueur;
    //Controlleur du joueur
    private final ControlleurJoueur controlleurJoueur;
    //Vue de la hitbox du joueur à afficher
    private final HitboxView hitboxJoueur;
    //liste des vies actuelle
    private ArrayList<View> listeVie;
    //liste les valeur pour la clé
    private ArrayList<ValeurHUDView> clés;
    
    //nb de clé actuelle
    private int nbclés;
    /**
     * Constructeur du joueur
     */
    public JoueurView() {
        //On passe en paramètre le sprite du joueur
        super(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Sprites/aliceFront.png");
        joueur = Partie.get().GetJoueur();
        //Le joueur est observé par la vue
        joueur.Register(this); 
        controlleurJoueur = new ControlleurJoueur(joueur); 
        this.nbclés = 0;
        //Création de la vue de la hitbox du joueur
        hitboxJoueur = new HitboxView(Partie.get().GetJoueur().getHitbox());
        //ligne à commenter si on rendre l'hitbox du joueur transparente
        //hitboxJoueur.setStroke(Color.RED);
        //La ligne ci-dessous rajoute la hitbox du joueur sur l'affichage
        GamePane.get().addView(hitboxJoueur);
        //init l'hud de la vie
        this.listeVie = new ArrayList<>();
        //init l'hud des clé
        this.clés = new ArrayList<>();
        InstanceVieHUD();
        InstanceCléHUD();
        
        Partie.get().addICollision(joueur);
    }
    
    /**
     * Déplace le sprite du joueur
     */
    private void moveSpriteJoueur()
    {
        //Coordonnee du joueur au moment de l'appel de la méthode
        Coordonnee coordonnee = joueur.getCoordonnee();
        double x = coordonnee.getX();
        double y = coordonnee.getY();
        //Déplacement de sprite
        translate(x, y);
    }

    @Override
    public void Update(String message) {
        if(message.toLowerCase().equals("haut")){
            this.setImage(new Image(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Sprites/aliceBack.png"));
        }
        if(message.toLowerCase().equals("bas")){
            this.setImage(new Image(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Sprites/aliceFront.png"));
        }
        if(message.toLowerCase().equals("gauche")){
            this.setImage(new Image(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Sprites/aliceLeft.png"));
        }
        if(message.toLowerCase().equals("droite")){
            this.setImage(new Image(System.getProperty("user.dir") + "/src/thebindingofalice/Images/Sprites/aliceRight.png"));
        }
        if(message.toLowerCase().equals("joueur"))
        {            
            moveSpriteJoueur();
        }else if(message.toLowerCase().equals("healrouge"))
        {
            AddCoeur(TypeCoeur.ROUGE);
        }
        else if(message.toLowerCase().equals("degat"))
        {
            prendDegat();
        }else if(message.toLowerCase().equals("cle"))
        {
            this.AddClé(1);
        }
    }
    
    /**
     * Appelle le controlleur pour demander au joueur de bouger
     * @param d dans la direction donnée
     */
    public void bouger(DirectionDeplacement d)
    {
        controlleurJoueur.bouger(d);
    }  
    
    /**
     * Appelle le controlleur pour demander au joueur d'arrêter de bouger 
     * @param d dans la direction donnée
     */
    public void sArreter(DirectionDeplacement d)
    {
        controlleurJoueur.sArreter(d);
    }

    /**
     * Appelle le controlleur pour demander au joueur de tirer 
     * @param d dans la direction donnée
     */
    public void tirer(DirectionTir d)
    {
        controlleurJoueur.tirer(d);        
    }
    
    /**
     * Appelle le controlleur pour demander au joueur d'arrêter de tirer 
     * @param d dans la direction donnée
     */
    public void stopTirer(DirectionTir d){
        controlleurJoueur.stopTirer(d);
    }
    
    /**
     * Méthode qui appelle le controlleur pour demander à la classe joueur de poser une bombe
     */
    public void poserBombe() {
        controlleurJoueur.poserBombe();
    }
    
        /**
     * initialise la view de coeur
     */
    private void InstanceVieHUD() {
        float posx = 0;
        //float espaceEntreCoeur = 2.5f;
        float ligne = 20;
        int nbmaxvieLigne = 4; // nombre de coeur max sur une ligne
        int vieActu = 0;
        View CoeurDroit;
        View CoeurGauche;
        for(int x = 0 ; x < Partie.get().GetJoueur().getVie().size(); x++)
        {
            Coordonnee coord = new Coordonnee(posx,ligne);
            if((x % 2 == 0 || x == 0)&& (this.joueur.getVieMax() != this.listeVie.size()))
            {
                //Paire soit gauche
                //peut-etre faire le cas pour le 0
                switch(Partie.get().GetJoueur().getVie().get(x))
                {
                    default:
                        CoeurHUDGauche cg = new CoeurHUDGauche(coord);
                        CoeurGauche = new CoeurHUDGaucheView(cg);  
                        GamePane.get().addView(CoeurGauche);
                        this.listeVie.add(CoeurGauche);
                        posx += CoeurGauche.getImage().getWidth();
                        break;
                }
                
            }else if(this.joueur.getVieMax() != this.listeVie.size())
            {
                //Impaire soit droite
                switch(Partie.get().GetJoueur().getVie().get(x))
                {
                    default:
                        CoeurHUDDroit cd = new CoeurHUDDroit(coord);
                        CoeurDroit = new CoeurHUDDroitView(cd);
                        GamePane.get().addView(CoeurDroit);
                        this.listeVie.add(CoeurDroit);
                        posx += CoeurDroit.getImage().getWidth();
                        vieActu +=1;
                        break;
                }
                if(vieActu == nbmaxvieLigne)
                {
                    ligne += CoeurDroit.getImage().getHeight();
                    posx = 0;
                    vieActu = 0;
                }
            }
        
        }
    }
    /**
     * ajout de coeur a la view
     * @param type 
     */
    private void AddCoeur(TypeCoeur type)
    {
        switch (type)
        {
            case ROUGE:
                for(View coeur : listeVie)
                {
                    GamePane.get().removeView(coeur);
                }
                this.listeVie.clear();
                this.InstanceVieHUD();
                break;
        
        }
    
    }

    private void prendDegat() {
        for (View coeur : listeVie) {
            GamePane.get().removeView(coeur);
        }
        this.listeVie.clear();
        this.InstanceVieHUD();
    }
    
    /**
     * gere le l'affichage du stock de clé
     */
    private void InstanceCléHUD()
    {
        double posx = 0.0;
        Coordonnee coord;
        coord = new Coordonnee(posx,this.listeVie.get(this.listeVie.size()-1).getTranslateY()+(this.listeVie.get(this.listeVie.size()-1).getImage().getHeight())*2);
        Cle cle = new Cle(coord);
        CléView cleview = new CléView(cle);
        GamePane.get().addView(cleview);
        posx += cleview.getImage().getWidth();
        for(int nbval = 0; nbval <3; nbval ++)
        {
            coord = new Coordonnee(posx,this.listeVie.get(this.listeVie.size()-1).getTranslateY()+this.listeVie.get(this.listeVie.size()-1).getImage().getHeight()*2+15);
            ValeurHUD val = new ValeurHUD(coord);
            ValeurHUDView valview = new ValeurHUDView(val);
            GamePane.get().addView(valview);
            this.clés.add(valview);
            posx += valview.getImage().getWidth();
        }
        
    }
    /**
     * ajoute une clé au joueur
     * @param nbclé 
     */
    private void AddClé(int nbclé)
    {
        int centaine = this.clés.get(0).getValeur();
        int dizaine = this.clés.get(1).getValeur();
        int unité = this.clés.get(2).getValeur();
        
        
        if(centaine == 9 && dizaine == 9 && unité == 9)
        {
        }else{
            unité += nbclé;
            if(unité >= 10)
            {
                dizaine += unité / 10;
                unité = unité % 10;
            }
            if(dizaine >= 10)
            {
                centaine += dizaine / 10;
                dizaine = dizaine % 10;

            }
        }
        
        
        try {
            this.clés.get(0).changeValeur(centaine);
            this.clés.get(1).changeValeur(dizaine);
            this.clés.get(2).changeValeur(unité);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JoueurView.class.getName()).log(Level.SEVERE, null, ex);
        }
            

            
        this.nbclés = unité + dizaine * 10 + centaine * 100;
    }

    

}
