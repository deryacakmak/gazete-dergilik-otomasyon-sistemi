package com.gazete_dergi_otomasyon.model;

public enum EType {

    DERGI("Dergi"),
    GAZETE("Gazete");

    public  final String  label;

    EType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
