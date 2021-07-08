package com.gazete_dergi_otomasyon.controller;

import com.gazete_dergi_otomasyon.model.Genre;
import com.gazete_dergi_otomasyon.service.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class GenreController {

    @Autowired
    private IGenreService genreService;

    public List<Genre> getAllGenre(){
        return this.genreService.getAllGenre();
    }


}
