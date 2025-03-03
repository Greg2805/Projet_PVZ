package com.epf.Model;

public class Plante {
    private int id_plante;
    private String nom;
    private int point_de_vie;
    private int attaque_par_seconde;
    private int degat_attaque;
    private int cout;
    private double soleil_par_seconde;
    private Effet effet;
    private String chemin_image;

    public Plante(String chemin_image, Effet effet, int cout, double soleil_par_seconde,
                  int degat_attaque, int attaque_par_seconde, int point_de_vie, String nom, int id_plante) {
        this.chemin_image = chemin_image;
        this.effet = effet;
        this.cout = cout;
        this.soleil_par_seconde = soleil_par_seconde;
        this.degat_attaque = degat_attaque;
        this.attaque_par_seconde = attaque_par_seconde;
        this.point_de_vie = point_de_vie;
        this.nom = nom;
        this.id_plante = id_plante;
    }

    public Plante() {
    }

    public void setId_plante(int id_plante) {
        this.id_plante = id_plante;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPoint_de_vie(int point_de_vie) {
        this.point_de_vie = point_de_vie;
    }

    public void setAttaque_par_seconde(int attaque_par_seconde) {
        this.attaque_par_seconde = attaque_par_seconde;
    }

    public void setDegat_attaque(int degat_attaque) {
        this.degat_attaque = degat_attaque;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public void setEffet(Effet effet) {
        this.effet = effet;
    }

    public void setSoleil_par_seconde(double soleil_par_seconde) {
        this.soleil_par_seconde = soleil_par_seconde;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }

    public String getNom() {
        return nom;
    }

    public int getId_plante() {
        return id_plante;
    }

    public Effet getEffet() {
        return effet;
    }

    public int getPoint_de_vie() {
        return point_de_vie;
    }

    public int getAttaque_par_seconde() {
        return attaque_par_seconde;
    }

    public int getDegat_attaque() {
        return degat_attaque;
    }

    public int getCout() {
        return cout;
    }

    public double getSoleil_par_seconde() {
        return soleil_par_seconde;
    }

    public String getChemin_image() {
        return chemin_image;
    }
}
