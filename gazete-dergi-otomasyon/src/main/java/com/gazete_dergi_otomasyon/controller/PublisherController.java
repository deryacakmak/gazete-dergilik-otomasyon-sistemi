package com.gazete_dergi_otomasyon.controller;

import com.gazete_dergi_otomasyon.dto.UploadJournalDto;
import com.gazete_dergi_otomasyon.model.Publisher;
import com.gazete_dergi_otomasyon.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Controller
public class PublisherController {

    @Autowired
    private IPublisherService publisherService;

    public PublisherController() {
    }


    public List<Publisher> getAllPublisher(){
        return this.publisherService.getAllPublisher();
    }

    public String savePublisher(UploadJournalDto uploadJournalDto){
        Publisher publisher = new Publisher(uploadJournalDto.getPublisher());
        this.publisherService.savePublisher(publisher);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                "Yeni yayıncı eklendi!", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "";
    }


}
