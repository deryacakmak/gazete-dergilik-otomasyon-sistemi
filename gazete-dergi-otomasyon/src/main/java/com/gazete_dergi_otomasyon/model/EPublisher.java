package com.gazete_dergi_otomasyon.model;

public enum EPublisher {

    POSTA("posta"),
    VOGUE("vogue"),
    ELLE("elle"),
    TIME("time" );

    public  final String  label;

    EPublisher(String label) {
        this.label = label;
    }
}
