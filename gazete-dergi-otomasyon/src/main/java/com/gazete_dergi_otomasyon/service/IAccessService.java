package com.gazete_dergi_otomasyon.service;

import com.gazete_dergi_otomasyon.model.User;
import com.gazete_dergi_otomasyon.exception.AccessException;

public interface IAccessService {

    public User login(String email, String password) throws AccessException;

}
