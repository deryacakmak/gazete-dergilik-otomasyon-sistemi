package com.gazete_dergi_otomasyon.model;

public enum EPublisher {

    POSTA("Posta"),
    VOGUE("Vogue"),
    ELLE("Elle"),
    TIME("Time" );

    public  final String  label;

    EPublisher(String label) {
        this.label = label;
    }
}
