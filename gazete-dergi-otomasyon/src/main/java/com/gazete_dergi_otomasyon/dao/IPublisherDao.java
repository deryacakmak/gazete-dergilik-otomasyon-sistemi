package com.gazete_dergi_otomasyon.dao;

import com.gazete_dergi_otomasyon.model.Publisher;

import java.util.List;

public interface IPublisherDao {

    List<Publisher> getAllPublisher();
    void savePublisher(Publisher publisher);
}
