package com.gazete_dergi_otomasyon.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JournalDao implements IJournalDao{


    @Autowired
    private SessionFactory sessionFactory;

    public JournalDao() {
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void saveJournal(com.gazete_dergi_otomasyon.model.Journal journal) {
        this.sessionFactory.getCurrentSession().save(journal);
    }
}
