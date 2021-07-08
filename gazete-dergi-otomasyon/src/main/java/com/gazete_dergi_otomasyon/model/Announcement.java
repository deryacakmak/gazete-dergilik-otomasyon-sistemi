package com.gazete_dergi_otomasyon.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "announcement")
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "publishing_date")
    @Temporal(TemporalType.DATE)
    private Date publishingDate;

    @OneToOne
    private User publisher;

    public Announcement() {}

    public Announcement(Long id, String title, String content, Date publishingDate, User publisher) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.publishingDate = publishingDate;
        this.publisher = publisher;
    }

    public Announcement(String title, String content) {
        this.title = title;
        this.content = content;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    public User getPublisher() {
        return publisher;
    }

    public void setPublisher(User publisher) {
        this.publisher = publisher;
    }


}
