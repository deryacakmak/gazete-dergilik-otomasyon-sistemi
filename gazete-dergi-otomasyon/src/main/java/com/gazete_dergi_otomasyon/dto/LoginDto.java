package com.gazete_dergi_otomasyon.dto;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named("loginDto")
@RequestScoped
public class LoginDto {


    private String email;
    private String password;

    public LoginDto() { }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

