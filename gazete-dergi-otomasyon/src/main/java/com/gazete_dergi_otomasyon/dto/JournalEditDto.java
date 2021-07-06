package com.gazete_dergi_otomasyon.dto;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import java.util.Date;

@Named("journalEditDto")
@RequestScoped
public class JournalEditDto {

   private String title;
   private String type;
   private String genre;
    private String issueNumber;
    private String publisher;
    private Date date;

    public JournalEditDto() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
