package com.gazete_dergi_otomasyon.controller;


import com.gazete_dergi_otomasyon.dto.UploadJournalDto;
import com.gazete_dergi_otomasyon.model.Genre;
import com.gazete_dergi_otomasyon.service.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GenreController {

    @Autowired
    private IGenreService genreService;

    public GenreController() {
    }

    public IGenreService getGenreService() {
        return genreService;
    }

    public void setGenreService(IGenreService genreService) {
        this.genreService = genreService;
    }

    public List<Genre> getAllGenre(){
        return this.genreService.getAllGenre();
    }

    public String addGenre(UploadJournalDto uploadJournalDto){
        Genre genre = new Genre(uploadJournalDto.getGenre());
        this.genreService.saveGenre(genre);

        return "";
    }


}
