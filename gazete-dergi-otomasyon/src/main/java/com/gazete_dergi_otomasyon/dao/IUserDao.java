package com.gazete_dergi_otomasyon.dao;


import com.gazete_dergi_otomasyon.model.User;

import java.util.List;

public interface IUserDao {

    User findUserByEmail(String email);
    void saveUser(User user);
    List<User> getAllUser();
    void removeUser(User user);


}
