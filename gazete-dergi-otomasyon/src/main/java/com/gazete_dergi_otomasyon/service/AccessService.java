package com.gazete_dergi_otomasyon.service;

import com.gazete_dergi_otomasyon.dao.IUserDao;
import com.gazete_dergi_otomasyon.model.User;
import com.gazete_dergi_otomasyon.dao.UserDao;
import com.gazete_dergi_otomasyon.exception.AccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
public class AccessService implements IAccessService {

    @Autowired
    private IUserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public User login(String email, String password) throws AccessException {
        User user =  this.userDao.findUserByEmail(email);
        if(user != null){
            if (user.getPassword().equals(password)){
                return user;
            }
            else{
                throw new AccessException("Wrong password!");
            }
        }
        else{
            throw new AccessException("There is no user with this email");
        }

    }

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}
