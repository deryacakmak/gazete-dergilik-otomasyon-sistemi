package com.gazete_dergi_otomasyon.controller;

import com.gazete_dergi_otomasyon.model.Publisher;
import com.gazete_dergi_otomasyon.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class PublisherController {

    @Autowired
    private IPublisherService publisherService;

    public List<Publisher> getAllPublisher(){
        return this.publisherService.getAllPublisher();
    }

}
