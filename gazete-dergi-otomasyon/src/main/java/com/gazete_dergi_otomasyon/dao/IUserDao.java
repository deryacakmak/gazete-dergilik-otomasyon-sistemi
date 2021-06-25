package com.gazete_dergi_otomasyon.dao;


import com.gazete_dergi_otomasyon.model.User;

public interface IUserDao {

    User findUserByEmail(String email);


}
