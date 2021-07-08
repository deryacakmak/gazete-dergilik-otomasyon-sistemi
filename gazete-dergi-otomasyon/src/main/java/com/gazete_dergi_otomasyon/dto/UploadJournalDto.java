package com.gazete_dergi_otomasyon.dto;

import org.primefaces.model.file.UploadedFile;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.util.Date;

@Named("uploadJournalDto")
@ViewScoped
public class UploadJournalDto {

    private String title;
    private String type;
    private String genre;
    private String publisher;
    private Date date;
    private String issueNumber;
    private UploadedFile file;
    private String fileName;
    private String newPublisher;
    private String newGenre;

    public String getNewPublisher() {
        return newPublisher;
    }

    public void setNewPublisher(String newPublisher) {
        this.newPublisher = newPublisher;
    }

    public String getNewGenre() {
        return newGenre;
    }

    public void setNewGenre(String newGenre) {
        this.newGenre = newGenre;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
