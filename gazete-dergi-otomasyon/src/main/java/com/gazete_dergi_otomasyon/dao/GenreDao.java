package com.gazete_dergi_otomasyon.dao;

import com.gazete_dergi_otomasyon.model.Genre;
import com.gazete_dergi_otomasyon.model.Publisher;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class GenreDao implements IGenreDao{


    @Autowired
    private SessionFactory sessionFactory;

    public GenreDao() { }


    @Override
    public List<Genre> getAllGenre() {
        return this.sessionFactory.getCurrentSession().createQuery("SELECT genre FROM Genre").list();
    }

    @Override
    public void saveGenre(Genre genre) {
        this.sessionFactory.getCurrentSession().save(genre);
    }

    @Override
    public Genre getGenreByName(String name) {
        List<Genre> genreList = new ArrayList<Genre>();

        genreList = this.sessionFactory.getCurrentSession()
                .createQuery("FROM Genre WHERE genre=?")
                .setParameter(0, name).list();

        if (genreList.size() > 0) {
            return genreList.get(0);
        } else {
            return null;
        }
    }
}

