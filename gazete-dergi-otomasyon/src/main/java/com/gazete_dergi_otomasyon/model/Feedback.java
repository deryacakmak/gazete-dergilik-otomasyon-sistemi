package com.gazete_dergi_otomasyon.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATE")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @OneToOne
    private Journal journal;

    @OneToOne
    private User  user;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "RATE")
    private Long rate;


    public Feedback() { }


    public Feedback(Long id, Date date, Journal journal, User user, String content, Long rate) {
        this.id = id;
        this.date = date;
        this.journal = journal;
        this.user = user;
        this.content = content;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }
}
