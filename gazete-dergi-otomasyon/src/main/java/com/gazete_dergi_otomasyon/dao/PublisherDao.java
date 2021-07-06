package com.gazete_dergi_otomasyon.dao;

import com.gazete_dergi_otomasyon.model.Publisher;
import com.gazete_dergi_otomasyon.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PublisherDao implements IPublisherDao {

    @Autowired
    private SessionFactory sessionFactory;

    public PublisherDao() { }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }


    @Override
    public List<Publisher> getAllPublisher() {
        return this.getSessionFactory().getCurrentSession().createQuery("SELECT publisherName FROM Publisher").list();
    }

    @Override
    public void savePublisher(Publisher publisher) {
        this.sessionFactory.getCurrentSession().save(publisher);
    }

    @Override
    public Publisher getPublisherByName(String name) {
        List<Publisher> publisherList = new ArrayList<Publisher>();

        publisherList = this.sessionFactory.getCurrentSession()
                .createQuery("FROM Publisher WHERE name=?")
                .setParameter(0, name).list();

        if (publisherList.size() > 0) {
            return publisherList.get(0);
        } else {
            return null;
        }
    }
}
