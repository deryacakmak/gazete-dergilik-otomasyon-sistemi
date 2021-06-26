package com.gazete_dergi_otomasyon.service;

import com.gazete_dergi_otomasyon.model.User;
import com.gazete_dergi_otomasyon.exception.AccessException;

public interface IAccessService {

     User login(String email, String password) throws AccessException;
     void signUp(String email, String firstName, String lastname, String password ) throws AccessException;

}
