package com.gazete_dergi_otomasyon.controller;


import com.gazete_dergi_otomasyon.dto.UploadJournalDto;
import com.gazete_dergi_otomasyon.model.*;
import com.gazete_dergi_otomasyon.service.IJournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;
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

    public String addJournal(UploadJournalDto uploadJournalDto){
        Publisher publisher = new Publisher(uploadJournalDto.getPublisher());
        Genre genre = new Genre(uploadJournalDto.getGenre());
        Journal journal = new Journal(EType.valueOf(uploadJournalDto.getType().toUpperCase(Locale.ROOT)), uploadJournalDto.getTitle(), uploadJournalDto.getDate(),uploadJournalDto.getName(), publisher, genre, uploadJournalDto.getIssueNumber());
        this.journalService.addJournal(journal);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                "Yayın ekleme işlemi başarılı!","");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "";
    }

    public List<Journal> getAllJournal(){
        return this.journalService.getAllJournal();
    }

    public void removeJournal(Journal journal){
        this.journalService.removeJournal(journal);
    }






}
