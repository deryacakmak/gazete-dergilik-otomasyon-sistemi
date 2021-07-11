package com.gazete_dergi_otomasyon.service;

import com.gazete_dergi_otomasyon.dao.IUserDao;
import com.gazete_dergi_otomasyon.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserDao userDao;


    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    @Transactional
    public void removeUser(User user) {
        this.userDao.removeUser(user);
    }
}
