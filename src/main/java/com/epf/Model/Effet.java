package com.epf.Model;


import com.fasterxml.jackson.annotation.JsonCreator;

public enum Effet {
    NORMAL("normal"),
    SLOW ("slow"),
    SLOW_LOW ("slow low"),
    SLOW_MEDIUM("slow medium"),
    SLOW_STOP("slow stop");

    private final String label;

    Effet(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @JsonCreator
    public static Effet fromString(String label) {
        for (Effet effet : Effet.values()) {
            if (effet.label.equalsIgnoreCase(label)) {
                return effet;
            }
        }
        throw new IllegalArgumentException("Aucun effet correspondant pour: " + label);
    }
}
