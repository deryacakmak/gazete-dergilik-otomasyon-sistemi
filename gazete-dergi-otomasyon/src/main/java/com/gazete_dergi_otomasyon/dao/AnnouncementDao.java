package com.gazete_dergi_otomasyon.dao;

import com.gazete_dergi_otomasyon.model.Announcement;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AnnouncementDao implements IAnnouncementDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addAnnouncement(Announcement announcement) {
        this.sessionFactory.getCurrentSession().save(announcement);
    }

    @Override
    public void deleteAnnouncement(Announcement announcement) {
        this.sessionFactory.getCurrentSession().delete(announcement);

    }

    @Override
    public List<Announcement> getAllAnnouncement() {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Announcement.class);
        return criteria.list();
    }

    @Override
    public void updateAnnouncement(Announcement announcement) {
        this.sessionFactory.getCurrentSession().update(announcement);
    }
}
