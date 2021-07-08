package com.gazete_dergi_otomasyon.dao;


import com.gazete_dergi_otomasyon.model.Genre;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public class GenreDao implements IGenreDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Genre> getAllGenre() {
        CriteriaBuilder cb = this.sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Genre> cr = cb.createQuery(Genre.class);
        Root<Genre> root = cr.from(Genre.class);
        cr.select(root).where(cb.isNotNull(root.get("genre")));
        Query<Genre> query = this.sessionFactory.getCurrentSession().createQuery(cr);
        List<Genre> results = query.getResultList();
        return results;
    }

    @Override
    public void saveGenre(Genre genre) {
        this.sessionFactory.getCurrentSession().save(genre);
    }

    @Override
    public Genre getGenreByName(String name) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Genre.class);
       criteria.add(Restrictions.eq("genre", name));
       List<Genre> result = criteria.list();
       if(result.isEmpty()){
           return null;
       }
       return result.get(0);
    }
}

