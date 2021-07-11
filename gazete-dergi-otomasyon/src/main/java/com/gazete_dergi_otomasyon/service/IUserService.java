package com.gazete_dergi_otomasyon.service;

import com.gazete_dergi_otomasyon.model.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUser();
    void removeUser(User user);
}
