package com.epf.Model;


public enum Effet {
    SLOW ("slow"),
    SLOW_LOW ("slow low"),
    SLOW_MEDIUM("slow medium"),
    SLOW_HARD("slow hard");

    private final String label;

    Effet(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }


    public static Effet fromString(String label) {
        for (Effet effet : Effet.values()) {
            if (effet.label.equalsIgnoreCase(label)) {
                return effet;
            }
        }
        throw new IllegalArgumentException("Aucun effet correspondant pour: " + label);
    }
}
