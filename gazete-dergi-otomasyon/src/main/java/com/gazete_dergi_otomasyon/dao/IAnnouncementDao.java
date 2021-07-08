package com.gazete_dergi_otomasyon.dao;

import com.gazete_dergi_otomasyon.model.Announcement;
import java.util.List;

public interface IAnnouncementDao {

     void addAnnouncement(Announcement announcement);
     void deleteAnnouncement(Announcement announcement);
     List<Announcement> getAllAnnouncement();
     void updateAnnouncement(Announcement announcement);



}
