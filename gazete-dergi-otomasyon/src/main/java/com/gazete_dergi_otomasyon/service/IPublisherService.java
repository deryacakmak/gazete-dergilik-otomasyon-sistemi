package com.gazete_dergi_otomasyon.service;

import com.gazete_dergi_otomasyon.exception.RecordNotFoundException;
import com.gazete_dergi_otomasyon.model.Publisher;

import java.util.List;

public interface IPublisherService {

    List<Publisher> getAllPublisher();
    void savePublisher(Publisher publisher);
    Publisher getPublisherByName(String name) throws RecordNotFoundException;
}
