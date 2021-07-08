package com.gazete_dergi_otomasyon.dto;


import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named("announcementEditDto")
@RequestScoped
public class AnnouncementEditDto {

    private String title;
    private String content;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return content;
    }

    public void setContext(String context) {
        this.content = context;
    }
}
