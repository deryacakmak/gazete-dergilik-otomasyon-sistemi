package com.gazete_dergi_otomasyon.controller;

import com.gazete_dergi_otomasyon.dto.UploadJournalDto;
import com.gazete_dergi_otomasyon.model.EPublisher;
import com.gazete_dergi_otomasyon.model.Publisher;
import com.gazete_dergi_otomasyon.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PublisherController {

    @Autowired
    private IPublisherService publisherService;

    public PublisherController() {
    }

    public IPublisherService getPublisherService() {
        return publisherService;
    }

    public void setPublisherService(IPublisherService publisherService) {
        this.publisherService = publisherService;
    }

    public List<Publisher> getAllPublisher(){
        return this.publisherService.getAllPublisher();
    }

    public String savePublisher(UploadJournalDto uploadJournalDto){
        Publisher publisher = new Publisher(EPublisher.valueOf(uploadJournalDto.getPublisher()));
        this.publisherService.savePublisher(publisher);
        return "";
    }


}
