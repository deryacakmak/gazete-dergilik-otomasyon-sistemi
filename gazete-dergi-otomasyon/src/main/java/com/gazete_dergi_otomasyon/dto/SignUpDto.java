package com.gazete_dergi_otomasyon.dto;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named("signUpDto")
@RequestScoped
public class SignUpDto {

    private String email;
    private String firstName;
    private String lastName;
    private String password;

    public SignUpDto() {
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}