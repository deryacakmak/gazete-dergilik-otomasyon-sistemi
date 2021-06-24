package com.gazete_dergi_otomasyon.model;

public enum EGenre {


    SPORT("sport"),
    BUSINESS("business"),
    FASHION("fashion"),
    ENTERTAINMENT("entertainment" ),
    HOME("home"),
    GARDEN("garden");

    public  final String  label;

    EGenre(String label) {
        this.label = label;
    }
}
