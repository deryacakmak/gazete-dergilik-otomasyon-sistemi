package com.gazete_dergi_otomasyon.dao;

import com.gazete_dergi_otomasyon.model.Journal;

import java.util.List;

public interface IJournalDao {

    void saveJournal(Journal journal);
    void removeJournal(Journal journal);
    void updateJournal(Journal journal);
    List<Journal> getAllJournal();
}
