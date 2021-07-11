package com.gazete_dergi_otomasyon.dao;

import com.gazete_dergi_otomasyon.model.ERole;
import com.gazete_dergi_otomasyon.model.Role;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDao implements IRoleDao{

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Role getRole(ERole role) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Role.class);
        criteria.add(Restrictions.eq("role", role));
        List<Role> roles = criteria.list();
        if (roles.isEmpty()) {
            return null;
        }
        return roles.get(0);
    }
}
