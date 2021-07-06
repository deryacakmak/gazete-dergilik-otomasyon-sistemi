package com.gazete_dergi_otomasyon.service;


import com.gazete_dergi_otomasyon.dao.IGenreDao;
import com.gazete_dergi_otomasyon.exception.RecordNotFoundException;
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


    @Override
    @Transactional(readOnly = true)
    public List<Genre> getAllGenre() {
        return this.genreDao.getAllGenre();
    }

    @Override
    @Transactional
    public void saveGenre(Genre genre) {
            this.genreDao.saveGenre(genre);
    }

    @Override
    @Transactional(readOnly = true)
    public Genre getGenreByName(String name) throws RecordNotFoundException {
      Genre genre = this.genreDao.getGenreByName(name);
      if(genre != null){
          return genre;
      }
      throw new RecordNotFoundException("Seçtiğiniz tür bulunamadı. Lütfe yeni tür ekleyin!");
    }
}
