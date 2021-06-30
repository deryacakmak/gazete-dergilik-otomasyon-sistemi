package com.gazete_dergi_otomasyon.dao;

import com.gazete_dergi_otomasyon.model.Genre;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class GenreDao implements IGenreDao{


    @Autowired
    private SessionFactory sessionFactory;

    public GenreDao() { }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Genre> getAllGenre() {
        return this.sessionFactory.getCurrentSession().createQuery("SELECT genre FROM Genre").list();
    }

    @Override
    public void saveGenre(Genre genre) {
        this.sessionFactory.getCurrentSession().save(genre);
    }
}
