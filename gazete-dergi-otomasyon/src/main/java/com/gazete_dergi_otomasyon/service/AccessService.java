package com.gazete_dergi_otomasyon.service;

import com.gazete_dergi_otomasyon.dao.IUserDao;
import com.gazete_dergi_otomasyon.model.ERole;
import com.gazete_dergi_otomasyon.model.Role;
import com.gazete_dergi_otomasyon.model.User;
import com.gazete_dergi_otomasyon.exception.AccessException;
import com.gazete_dergi_otomasyon.util.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.security.NoSuchAlgorithmException;

@Service
public class AccessService implements IAccessService {

    @Autowired
    private IUserDao userDao;

    public static User currentUser;

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "currentUser")
    public User login(String email, String password) throws AccessException, NoSuchAlgorithmException {
        User user =  this.userDao.findUserByEmail(email);
        if(user != null){
            if (user.getPassword().equals(Encryption.MD5(password))){
                this.currentUser = user;
                return user;
            }
            throw new AccessException("Yanlış şifre! Lütfen şifrenizi kontrol edin.");
        }
            throw new AccessException("Sisteme kayıtlı mail adresi bulunamadı!");
    }

    @Override
    @Transactional(rollbackFor = {AccessException.class, NoSuchAlgorithmException.class})
    public void signUp( String firstName, String lastName, String email, String password) throws AccessException, NoSuchAlgorithmException {
        User user =  this.userDao.findUserByEmail(email);
        if(user != null){
            throw new AccessException("Bu mail adresi kullanılıyor!");
        }
            User newUser = new User(firstName, lastName, email, Encryption.MD5(password));
            Role role = new Role(ERole.ROLE_MEMBER);
            newUser.getRole().add(role);
            this.userDao.saveUser(newUser);
    }



}
