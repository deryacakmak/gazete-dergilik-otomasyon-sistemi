package com.gazete_dergi_otomasyon.dao;

import com.gazete_dergi_otomasyon.model.Publisher;
import com.gazete_dergi_otomasyon.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao implements IUserDao{

    @Autowired
    private  SessionFactory sessionFactory;

    @Override
    public User findUserByEmail(String email) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("email", email));
        List<User> users = criteria.list();
        if (users.isEmpty()) {
            return null;
        } else {
            return users.get(0);
        }
    }

    @Override
    public void saveUser(User user) {
        this.sessionFactory.getCurrentSession().save(user);
    }


}
