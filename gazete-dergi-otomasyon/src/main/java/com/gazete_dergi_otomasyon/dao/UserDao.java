package com.gazete_dergi_otomasyon.dao;

import com.gazete_dergi_otomasyon.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao implements IUserDao{

    @Autowired
    private  SessionFactory sessionFactory;

    public UserDao() { }



    @Override
    public User findUserByEmail(String email) {
        List<User> users = new ArrayList<User>();

        users = this.sessionFactory.getCurrentSession()
                .createQuery("FROM User WHERE email=?")
                .setParameter(0, email).list();

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void saveUser(User user) {
        this.sessionFactory.getCurrentSession().save(user);
    }


}
