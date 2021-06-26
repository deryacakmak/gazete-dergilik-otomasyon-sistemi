package com.gazete_dergi_otomasyon.dao;

import com.gazete_dergi_otomasyon.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao implements IUserDao{

    @Autowired
     SessionFactory sessionFactory;


    public UserDao() { }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    @Override
    public User findUserByEmail(String email) {
        List<User> users = new ArrayList<User>();
        System.out.println(email);

        users = getSessionFactory().getCurrentSession()
                .createQuery("FROM User WHERE email=?")
                .setParameter(0, email).list();

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }



}
