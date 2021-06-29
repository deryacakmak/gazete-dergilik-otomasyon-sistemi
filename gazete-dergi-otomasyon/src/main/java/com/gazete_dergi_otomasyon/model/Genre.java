package com.gazete_dergi_otomasyon.model;

import javax.persistence.*;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "genre")
    private EGenre  genre;

    public Genre() {
    }

    public Genre(Long id, EGenre genre) {
        this.id = id;
        this.genre = genre;
    }

    public Genre(EGenre genre) {
        this.genre = genre;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EGenre getGenre() {
        return genre;
    }

    public void setGenre(EGenre genre) {
        this.genre = genre;
    }
}
