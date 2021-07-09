package com.gazete_dergi_otomasyon.service;

import com.gazete_dergi_otomasyon.dao.IAnnouncementDao;
import com.gazete_dergi_otomasyon.dto.AnnouncementEditDto;
import com.gazete_dergi_otomasyon.model.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AnnouncementService implements IAnnouncementService{

    @Autowired
    private IAnnouncementDao announcementDao;

    @Override
    @Transactional
    public void addAnnouncement(Announcement announcement) {
        announcement.setPublishingDate(new Date());
        this.announcementDao.addAnnouncement(announcement);
    }

    @Override
    @Transactional
    public void deleteAnnouncement(Announcement announcement) {
        this.announcementDao.deleteAnnouncement(announcement);

    }

    @Override
    @Transactional(readOnly = true)
    public List<Announcement> getAllAnnouncement() {
        return this.announcementDao.getAllAnnouncement();
    }

    @Override
    @Transactional
    public void updateAnnouncement(Announcement announcement, AnnouncementEditDto announcementEditDto) {
        announcement.setContent(announcementEditDto.getContext());
        announcement.setTitle(announcementEditDto.getTitle());
        announcement.setPublisher(AccessService.currentUser);
        this.announcementDao.updateAnnouncement(announcement);
    }
}
