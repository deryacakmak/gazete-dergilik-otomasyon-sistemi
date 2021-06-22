package com.gazete_dergi_otomasyon.model;

import javax.persistence.*;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "GENRE")
    private String  genre;

    public Genre() {
    }

    public Genre(Long id, String genre) {
        this.id = id;
        this.genre = genre;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
