package com.gazete_dergi_otomasyon.controller;

import com.gazete_dergi_otomasyon.dto.AnnouncementEditDto;
import com.gazete_dergi_otomasyon.model.Announcement;
import com.gazete_dergi_otomasyon.service.IAnnouncementService;
import org.primefaces.event.RowEditEvent;
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
        FacesMessage msg = new FacesMessage("Duyuru Silindi");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "";
    }
    public List<Announcement> getAllAnnouncement(){
        return this.announcementService.getAllAnnouncement();
    }

    public void updateAnnouncement(Announcement announcement, AnnouncementEditDto announcementEditDto){
        if(announcementEditDto.getContext() == ""){
            announcementEditDto.setContext(announcement.getContent());
        }
        if(announcementEditDto.getTitle() == ""){
            announcementEditDto.setTitle(announcement.getTitle());
        }
        this.announcementService.updateAnnouncement(announcement, announcementEditDto);
        FacesMessage msg = new FacesMessage("Duyuru Güncellendi");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        resetAnnouncementEditDto(announcementEditDto);
    }

    public void onAddNew() {
            Announcement newAnnouncement = new Announcement(" ", " ");
            this.addAnnouncement(newAnnouncement);
            FacesMessage msg = new FacesMessage("Yeni Duyuru Eklendi");
            FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    private void resetAnnouncementEditDto(AnnouncementEditDto announcementEditDto){
        announcementEditDto.setTitle(null);
        announcementEditDto.setContext(null);
    }

}
