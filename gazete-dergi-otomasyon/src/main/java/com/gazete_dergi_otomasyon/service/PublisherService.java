package com.gazete_dergi_otomasyon.service;

import com.gazete_dergi_otomasyon.dao.IPublisherDao;
import com.gazete_dergi_otomasyon.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService implements IPublisherService{

    @Autowired
    private IPublisherDao publisherDao;

    public PublisherService() { }

    public IPublisherDao getPublisherDao() {
        return publisherDao;
    }

    public void setPublisherDao(IPublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @Override
    public List<Publisher> getAllPublisher() {
        return this.publisherDao.getAllPublisher();
    }

    @Override
    public void savePublisher(Publisher publisher) {
        this.publisherDao.savePublisher(publisher);
    }



}
