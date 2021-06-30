package com.gazete_dergi_otomasyon.dao;

import com.gazete_dergi_otomasyon.model.Journal;

public interface IJournalDao {

    void saveJournal(Journal journal);
    void removeJournal(Journal journal);
}
