package com.gazete_dergi_otomasyon.dao;


import com.gazete_dergi_otomasyon.model.ERole;
import com.gazete_dergi_otomasyon.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
        }
        return users.get(0);

    }

    @Override
    public void saveUser(User user) {
        this.sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> getAllUser() {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.createAlias("roles", "rolesAlias");
        criteria.add(Restrictions.eq("rolesAlias.role", ERole.ROLE_MEMBER));
        return criteria.list();

    }

    @Override
    public void removeUser(User user) {
        this.sessionFactory.getCurrentSession().delete(user);
    }


}
