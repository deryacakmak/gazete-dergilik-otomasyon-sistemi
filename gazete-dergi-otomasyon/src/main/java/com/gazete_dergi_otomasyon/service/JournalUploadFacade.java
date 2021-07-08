package com.gazete_dergi_otomasyon.service;

import com.gazete_dergi_otomasyon.dto.UploadJournalDto;
import com.gazete_dergi_otomasyon.exception.RecordNotFoundException;
import com.gazete_dergi_otomasyon.model.EType;
import com.gazete_dergi_otomasyon.model.Genre;
import com.gazete_dergi_otomasyon.model.Journal;
import com.gazete_dergi_otomasyon.model.Publisher;
import com.gazete_dergi_otomasyon.service.IGenreService;
import com.gazete_dergi_otomasyon.service.IJournalService;
import com.gazete_dergi_otomasyon.service.IPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Locale;

@Service
public class JournalUploadFacade {

    @Autowired
    private IJournalService journalService;

    @Autowired
    private IPublisherService publisherService;

    @Autowired
    private IGenreService genreService;


    public void addJournal(UploadJournalDto uploadJournalDto){
        Publisher publisher;
        try {
            publisher = this.publisherService.getPublisherByName(uploadJournalDto.getPublisher());
        } catch (RecordNotFoundException e) {
            publisher = new Publisher(uploadJournalDto.getNewPublisher());
            this.publisherService.savePublisher(publisher);
        }
        Genre genre;
        try {
            genre = this.genreService.getGenreByName(uploadJournalDto.getGenre());
        } catch (RecordNotFoundException e) {
            genre = new Genre(uploadJournalDto.getNewGenre());
            this.genreService.saveGenre(genre);
        }
        Journal journal = new Journal(EType.valueOf(uploadJournalDto.getType().toUpperCase(Locale.ROOT)), uploadJournalDto.getTitle(), uploadJournalDto.getDate(), uploadJournalDto.getFile().getFileName(), publisher, genre, uploadJournalDto.getIssueNumber());
        this.journalService.addJournal(journal);


    }
}
