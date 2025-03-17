package com.epf.Dto;

public class MapDTO {
    private int nbLigne;
    private int nbColonne;

    public MapDTO(int nbLigne, int nbColonne) {
        this.nbLigne = nbLigne;
        this.nbColonne = nbColonne;
    }
    public MapDTO() {
    }
    public int getNbLigne() {
        return nbLigne;
    }
    public void setNbLigne(int nbLigne) {
        this.nbLigne = nbLigne;
    }
    public int getNbColonne() {
        return nbColonne;
    }
    public void setNbColonne(int nbColonne) {
        this.nbColonne = nbColonne;
    }
}
