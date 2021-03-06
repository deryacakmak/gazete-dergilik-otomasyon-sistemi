package com.gazete_dergi_otomasyon.service;


import com.gazete_dergi_otomasyon.dto.JournalEditDto;
import com.gazete_dergi_otomasyon.dto.UploadJournalDto;
import com.gazete_dergi_otomasyon.model.Journal;

import java.util.List;

public interface IJournalService {

    void addJournal(Journal journal);
    void removeJournal(Journal journal);
    void updateJournal(Journal journal, JournalEditDto journalEditDto);
    List<Journal> getAllJournal();

}
