package com.gazete_dergi_otomasyon.dao;

import com.gazete_dergi_otomasyon.model.Genre;
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
public class PublisherDao implements IPublisherDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Publisher> getAllPublisher() {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Publisher.class);
        criteria.add(Restrictions.isNotNull("publisherName"));
        return criteria.list();
    }

    @Override
    public void savePublisher(Publisher publisher) {
        this.sessionFactory.getCurrentSession().save(publisher);
    }

    @Override
    public Publisher getPublisherByName(String name) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Publisher.class);
        criteria.add(Restrictions.eq("publisherName", name));
        List<Publisher> result = criteria.list();
        if(result.isEmpty()){
            return null;
        }
        return result.get(0);

    }
}
