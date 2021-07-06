package com.gazete_dergi_otomasyon.service;

import com.gazete_dergi_otomasyon.dto.AnnouncementEditDto;
import com.gazete_dergi_otomasyon.model.Announcement;

import java.util.List;

public interface IAnnouncementService {

    void addAnnouncement(Announcement announcement);
    void deleteAnnouncement(Announcement announcement);
    List<Announcement> getAllAnnouncement();
    void updateAnnouncement(Announcement announcement,  AnnouncementEditDto announcementEditDto);

}
