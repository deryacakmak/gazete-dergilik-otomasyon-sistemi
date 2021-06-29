package com.gazete_dergi_otomasyon.dao;

import com.gazete_dergi_otomasyon.model.Genre;

import java.util.List;

public interface IGenreDao {

    List<Genre> getAllGenre();
    void saveGenre(Genre genre);
}
