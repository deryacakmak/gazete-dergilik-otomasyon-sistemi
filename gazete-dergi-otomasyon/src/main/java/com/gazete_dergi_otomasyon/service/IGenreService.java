package com.gazete_dergi_otomasyon.service;

import com.gazete_dergi_otomasyon.exception.RecordNotFoundException;
import com.gazete_dergi_otomasyon.model.Genre;

import java.util.List;

public interface IGenreService {

    List<Genre> getAllGenre();
    void saveGenre(Genre genre);
    Genre getGenreByName(String name) throws RecordNotFoundException;
}
