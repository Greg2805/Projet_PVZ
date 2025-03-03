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
}
