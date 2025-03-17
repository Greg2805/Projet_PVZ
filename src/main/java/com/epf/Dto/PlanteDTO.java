package com.epf.Dto;

public class PlanteDTO {
    private String nom;
    private int pointDeVie;
    private int degat_attaque;

    public PlanteDTO(String nom, int pointDeVie, int degat_attaque) {
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.degat_attaque = degat_attaque;
    }

    public PlanteDTO() {
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getPointDeVie() {
        return pointDeVie;
    }

    public void setPointDeVie(int pointDeVie) {
        this.pointDeVie = pointDeVie;
    }
    public int getDegat_attaque() {
        return degat_attaque;
    }
    public void setDegat_attaque(int degat_attaque) {
        this.degat_attaque = degat_attaque;
    }




}
