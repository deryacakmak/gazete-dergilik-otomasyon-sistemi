package com.gazete_dergi_otomasyon.service;


import com.gazete_dergi_otomasyon.dao.IGenreDao;
import com.gazete_dergi_otomasyon.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenreService implements IGenreService {

    @Autowired
    private IGenreDao genreDao;

    public GenreService() {
    }

    public IGenreDao getGenreDao() {
        return genreDao;
    }

    public void setGenreDao(IGenreDao genreDao) {
        this.genreDao = genreDao;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Genre> getAllGenre() {
        return this.genreDao.getAllGenre();
    }

    @Override
    public void saveGenre(Genre genre) {
            this.genreDao.saveGenre(genre);
    }
}
