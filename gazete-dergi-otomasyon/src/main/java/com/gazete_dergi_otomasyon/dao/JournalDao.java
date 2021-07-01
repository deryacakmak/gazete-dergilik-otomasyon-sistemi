package com.gazete_dergi_otomasyon.dao;


import com.gazete_dergi_otomasyon.model.Journal;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    @Transactional
    public void removeJournal(Journal journal) {
        this.sessionFactory.getCurrentSession().delete(journal);
    }

    @Override
    @Transactional
    public void updateJournal(Journal journal) {
        this.sessionFactory.getCurrentSession().update(journal);
    }

    @Override
    @Transactional
    public List<Journal> getAllJournal() {
        return this.sessionFactory.getCurrentSession().createQuery("FROM Journal").list();
    }


}
