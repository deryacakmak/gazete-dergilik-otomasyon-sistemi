package com.gazete_dergi_otomasyon.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "journal", indexes = {@Index(columnList = "title", name = "journal_title") })
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private EType type;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "file_path")
    private String path;


    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Publisher publisher;


    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Genre genre;

    @Column(name = "issue_number")
    private String IssueNumber ;


    public Journal() { }

    public Journal(int id, EType type, String title, Date date, String path, Publisher publisher, Genre genre, String issueNumber) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.date = date;
        this.path = path;
        this.publisher = publisher;
        this.genre = genre;
        IssueNumber = issueNumber;
    }

    public Journal(EType type, String title, Date date, String path, Publisher publisher, Genre genre, String issueNumber) {
        this.type = type;
        this.title = title;
        this.date = date;
        this.path = path;
        this.publisher = publisher;
        this.genre = genre;
        IssueNumber = issueNumber;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EType getType() {
        return type;
    }

    public void setType(EType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getIssueNumber() {
        return IssueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        IssueNumber = issueNumber;
    }
}
