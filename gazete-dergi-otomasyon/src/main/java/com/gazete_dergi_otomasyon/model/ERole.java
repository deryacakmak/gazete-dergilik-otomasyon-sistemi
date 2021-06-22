package com.gazete_dergi_otomasyon.model;

public enum ERole {

    ROLE_MEMBER("member"),
    ROLE_ADMIN("admin");

    public  final String  label;

    ERole(String label) {
        this.label = label;
    }
}
