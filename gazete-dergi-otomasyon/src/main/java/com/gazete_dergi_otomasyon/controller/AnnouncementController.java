package com.gazete_dergi_otomasyon.controller;

import com.gazete_dergi_otomasyon.dto.AnnouncementEditDto;
import com.gazete_dergi_otomasyon.model.Announcement;
import com.gazete_dergi_otomasyon.service.IAnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Controller
public class AnnouncementController {

    @Autowired
    private IAnnouncementService announcementService;

    public String addAnnouncement(Announcement announcement){
        this.announcementService.addAnnouncement(announcement);
        return "";
    }

    public String deleteAnnouncement(Announcement announcement){
        this.announcementService.deleteAnnouncement(announcement);
        return "";
    }

    public List<Announcement> getAllAnnouncement(){
        return this.announcementService.getAllAnnouncement();
    }

    public void updateAnnouncement(Announcement announcement, AnnouncementEditDto announcementEditDto){
        this.announcementService.updateAnnouncement(announcement, announcementEditDto);
        resetAnnouncementEditDto(announcementEditDto);
    }

    public void onAddNew() {
        Announcement newAnnouncement = new Announcement(" ", " ");
        this.addAnnouncement(newAnnouncement);
        FacesMessage msg = new FacesMessage("New Product added");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    private void resetAnnouncementEditDto(AnnouncementEditDto announcementEditDto){
        announcementEditDto.setTitle(null);
        announcementEditDto.setContext(null);
    }

}
