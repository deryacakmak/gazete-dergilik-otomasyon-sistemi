package com.gazete_dergi_otomasyon.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "userJournal")
public class UserJournal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    private Journal journal;

    @OneToOne
    private User user;

    @Column(name = "brace_page")
    private Long page;

    @Column(name = "favorite")
    private Long fav;

    @Column(name = "read_later")
    private Long readLater;

    public UserJournal() {
    }

    public UserJournal(Long id, Journal journal, User user, Long page, Long fav, Long readLater) {
        this.id = id;
        this.journal = journal;
        this.user = user;
        this.page = page;
        this.fav = fav;
        this.readLater = readLater;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getFav() {
        return fav;
    }

    public void setFav(Long fav) {
        this.fav = fav;
    }

    public Long getReadLater() {
        return readLater;
    }

    public void setReadLater(Long readLater) {
        this.readLater = readLater;
    }
}
