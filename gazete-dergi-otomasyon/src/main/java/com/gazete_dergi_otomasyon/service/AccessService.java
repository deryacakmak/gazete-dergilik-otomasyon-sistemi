package com.gazete_dergi_otomasyon.service;

import com.gazete_dergi_otomasyon.dao.IUserDao;
import com.gazete_dergi_otomasyon.model.ERole;
import com.gazete_dergi_otomasyon.model.Role;
import com.gazete_dergi_otomasyon.model.User;
import com.gazete_dergi_otomasyon.exception.AccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
public class AccessService implements IAccessService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User login(String email, String password) throws AccessException {
        User user =  this.userDao.findUserByEmail(email);
        if(user != null){
            if (user.getPassword().equals(password)){
                return user;
            }
            throw new AccessException("Yanlış şifre! Lütfen şifrenizi kontrol edin.");
        }
            throw new AccessException("Sisteme kayıtlı mail adresi bulunamadı!");


    }

    @Override
    public void signUp( String firstName, String lastName, String email,String password) throws AccessException {
        User user =  this.userDao.findUserByEmail(email);
        if(user != null){
            throw new AccessException("Bu mail adresi kullanılıyor!");
        }
            User newUser = new User(firstName, lastName, email, password);
            Role role = new Role(ERole.ROLE_MEMBER);
            newUser.getRole().add(role);
            this.userDao.saveUser(newUser);


    }

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}
