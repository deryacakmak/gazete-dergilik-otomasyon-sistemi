package com.gazete_dergi_otomasyon.service;

import com.gazete_dergi_otomasyon.dao.IUserDao;
import com.gazete_dergi_otomasyon.model.ERole;
import com.gazete_dergi_otomasyon.model.Role;
import com.gazete_dergi_otomasyon.model.User;
import com.gazete_dergi_otomasyon.exception.AccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class AccessService implements IAccessService {

    @Autowired
    private IUserDao userDao;

    public AccessService() {
    }

    @Override
    @Transactional(readOnly = true)
    public User login(String email, String password) throws AccessException, NoSuchAlgorithmException {
        User user =  this.userDao.findUserByEmail(email);
        if(user != null){
            if (user.getPassword().equals(MD5(password))){
                return user;
            }
            throw new AccessException("Yanlış şifre! Lütfen şifrenizi kontrol edin.");
        }
            throw new AccessException("Sisteme kayıtlı mail adresi bulunamadı!");
    }

    @Override
    @Transactional(rollbackFor = AccessException.class)
    public void signUp( String firstName, String lastName, String email,String password) throws AccessException, NoSuchAlgorithmException {
        User user =  this.userDao.findUserByEmail(email);
        if(user != null){
            throw new AccessException("Bu mail adresi kullanılıyor!");
        }
            User newUser = new User(firstName, lastName, email, MD5(password));
            Role role = new Role(ERole.ROLE_MEMBER);
            newUser.getRole().add(role);
            this.userDao.saveUser(newUser);
    }

    private static String MD5(String s) throws NoSuchAlgorithmException {
        MessageDigest m= MessageDigest.getInstance("MD5");
        m.update(s.getBytes(),0,s.length());
        return new BigInteger(1,m.digest()).toString(16);
    }

}
