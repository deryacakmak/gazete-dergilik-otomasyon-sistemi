package com.gazete_dergi_otomasyon.controller;


import com.gazete_dergi_otomasyon.dto.UploadJournalDto;
import com.gazete_dergi_otomasyon.model.*;
import com.gazete_dergi_otomasyon.service.IJournalService;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.*;
import java.util.Locale;

@Controller
public class JournalController {

    @Autowired
    private IJournalService journalService;


    public JournalController() {
    }

    public IJournalService getJournalService() {
        return journalService;
    }

    public void setJournalService(IJournalService journalService) {
        this.journalService = journalService;
    }

    public void addJournal(UploadJournalDto uploadJournalDto){
        Publisher publisher = new Publisher(uploadJournalDto.getPublisher());
        Genre genre = new Genre(uploadJournalDto.getGenre());
        Journal journal = new Journal(EType.valueOf(uploadJournalDto.getType().toUpperCase(Locale.ROOT)), uploadJournalDto.getTitle(), uploadJournalDto.getDate(),uploadJournalDto.getName(), publisher, genre, uploadJournalDto.getIssueNumber());
        this.journalService.addJournal(journal);
    }



}
