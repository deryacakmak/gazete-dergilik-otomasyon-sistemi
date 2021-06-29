package com.gazete_dergi_otomasyon.dao;

import com.gazete_dergi_otomasyon.model.Publisher;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PublisherDao implements IPublisherDao {

    @Autowired
    private SessionFactory sessionFactory;

    public PublisherDao() { }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Publisher> getAllPublisher() {
        return this.getSessionFactory().getCurrentSession().createQuery("FROM Publisher").list();
    }

    @Override
    public void savePublisher(Publisher publisher) {
        this.sessionFactory.getCurrentSession().save(publisher);
    }
}
