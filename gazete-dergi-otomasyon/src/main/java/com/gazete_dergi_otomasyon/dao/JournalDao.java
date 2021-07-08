package com.gazete_dergi_otomasyon.dao;


import com.gazete_dergi_otomasyon.model.Genre;
import com.gazete_dergi_otomasyon.model.Journal;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class JournalDao implements IJournalDao{


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveJournal(com.gazete_dergi_otomasyon.model.Journal journal) {
        this.sessionFactory.getCurrentSession().save(journal);
    }

    @Override
    public void removeJournal(Journal journal) {
        this.sessionFactory.getCurrentSession().delete(journal);
    }

    @Override
    public void updateJournal(Journal journal) {
        this.sessionFactory.getCurrentSession().update(journal);
    }

    @Override
    public List<Journal> getAllJournal() {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Journal.class);
        return criteria.list();

    }


}
