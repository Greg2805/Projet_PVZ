package com.epf.Model;

public class Map {
    private int ligne;
    private int colonne;
    private String cheminImage;
    private int id;

    public Map(int ligne, int colonne, String cheminImage, int id) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.cheminImage = cheminImage;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map(){
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public String getCheminImage() {
        return cheminImage;
    }

    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }
}
