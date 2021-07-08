package com.gazete_dergi_otomasyon.service;

import com.gazete_dergi_otomasyon.dao.IPublisherDao;
import com.gazete_dergi_otomasyon.exception.RecordNotFoundException;
import com.gazete_dergi_otomasyon.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PublisherService implements IPublisherService{

    @Autowired
    private IPublisherDao publisherDao;

    @Override
    @Transactional(readOnly = true)
    public List<Publisher> getAllPublisher() {
        return this.publisherDao.getAllPublisher();
    }

    @Override
    @Transactional
    public void savePublisher(Publisher publisher) {
        this.publisherDao.savePublisher(publisher);
    }

    @Override
    @Transactional(readOnly = true)
    public Publisher getPublisherByName(String name) throws RecordNotFoundException {
       Publisher publisher =  this.publisherDao.getPublisherByName(name);
       if(publisher != null){
           return publisher;
       }
       throw new RecordNotFoundException("Kayıtlı yayıncı bulunamadı. Lütfen yeni yayıncı ekleyin!");
    }


}
