package com.epf.Model;

public class Zombie {
    private int id_zombie;
    private String nom;
    private int point_de_vie;
    private int attaque_par_seconde;
    private int degat_attaque;
    private double vitesse_de_deplacement;
    private Effet effet;
    private String chemin_image;
    private int id_map;



    public Zombie(String chemin_image, Effet effet, double vitesse_de_deplacement, int degat_attaque,
                  int attaque_par_seconde, int point_de_vie, String nom, int id_zombie, int id_map) {
        this.chemin_image = chemin_image;
        this.effet = effet;
        this.vitesse_de_deplacement = vitesse_de_deplacement;
        this.degat_attaque = degat_attaque;
        this.attaque_par_seconde = attaque_par_seconde;
        this.point_de_vie = point_de_vie;
        this.nom = nom;
        this.id_zombie = id_zombie;
        this.id_map = id_map;
    }

    public Zombie() {

    }

    public int getId_map() {
        return id_map;
    }

    public void setId_map(int id_map) {
        this.id_map = id_map;
    }

    public int getId_zombie() {
        return id_zombie;
    }

    public String getNom() {
        return nom;
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

    public double getVitesse_de_deplacement() {
        return vitesse_de_deplacement;
    }

    public Effet getEffet() {
        return effet;
    }

    public String getChemin_image() {
        return chemin_image;
    }

    public void setId_zombie(int id_zombie) {
        this.id_zombie = id_zombie;
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

    public void setEffet(Effet effet) {
        this.effet = effet;
    }

    public void setVitesse_de_deplacement(double vitesse_de_deplacement) {
        this.vitesse_de_deplacement = vitesse_de_deplacement;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }
}
