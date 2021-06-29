package com.gazete_dergi_otomasyon.model;

public enum EGenre {


    SPORT("Sport"),
    BUSINESS("Business"),
    FASHION("Fashion"),
    ENTERTAINMENT("Entertainment" ),
    HOME("Home"),
    GARDEN("Garden");

    public  final String  label;

    EGenre(String label) {
        this.label = label;
    }
}
