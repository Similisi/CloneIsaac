package thebindingofalice.Metier;

public class Statistiques {
    private int vitesseDeplacement = 5;
    private int degats;
    private int cadenveTir = 25;
    private int porteeTir;
    private int vitesseProjectile;
    private int chance;
    
    public int getVitesseDeplacement() {
        return vitesseDeplacement;
    }

    public void setVitesseDeplacement(int vitesseDeplacement) {
        this.vitesseDeplacement = vitesseDeplacement;
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public int getCadenveTir() {
        return cadenveTir;
    }

    public void setCadenveTir(int cadenveTir) {
        this.cadenveTir = cadenveTir;
    }

    public int getPorteeTir() {
        return porteeTir;
    }

    public void setPorteeTir(int porteeTir) {
        this.porteeTir = porteeTir;
    }

    public int getVitesseProjectile() {
        return vitesseProjectile;
    }

    public void setVitesseProjectile(int vitesseProjectile) {
        this.vitesseProjectile = vitesseProjectile;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

}
