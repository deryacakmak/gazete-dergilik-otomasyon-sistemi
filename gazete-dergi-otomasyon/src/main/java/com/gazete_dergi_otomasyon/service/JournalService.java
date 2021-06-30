package com.gazete_dergi_otomasyon.service;

import com.gazete_dergi_otomasyon.dao.IJournalDao;
import com.gazete_dergi_otomasyon.model.Journal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JournalService implements IJournalService {


    @Autowired
    private IJournalDao journalDao;

    public JournalService() {
    }

    public IJournalDao getJournalDao() {
        return journalDao;
    }

    public void setJournalDao(IJournalDao journalDao) {
        this.journalDao = journalDao;
    }

    @Override
    public void addJournal(Journal journal) {
        this.journalDao.saveJournal(journal);
    }
}