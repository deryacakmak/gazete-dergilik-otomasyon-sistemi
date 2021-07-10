package com.gazete_dergi_otomasyon.service;

import com.gazete_dergi_otomasyon.dao.GenreDao;
import com.gazete_dergi_otomasyon.dao.IJournalDao;
import com.gazete_dergi_otomasyon.dao.PublisherDao;
import com.gazete_dergi_otomasyon.dto.JournalEditDto;
import com.gazete_dergi_otomasyon.model.EType;
import com.gazete_dergi_otomasyon.model.Journal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


@Service
@PropertySource("classpath:application.properties")
public class JournalService implements IJournalService {


    @Autowired
    private IJournalDao journalDao;
    @Value("${fileSave.path}" )
    private String filePath;


    @Override
    @Transactional
    public void addJournal(Journal journal) {
        journal.setPath(filePath+journal.getIssueNumber()+ "_"+journal.getPath());
        this.journalDao.saveJournal(journal);
    }

    @Override
    @Transactional
    public void removeJournal(Journal journal) {
        this.journalDao.removeJournal(journal);

    }

    @Override
    @Transactional
    public void updateJournal(Journal journal, JournalEditDto journalEditDto) {
        journal.setTitle(journalEditDto.getTitle());
        journal.setIssueNumber(journalEditDto.getIssueNumber());
        journal.setDate(journalEditDto.getDate());
        journal.setType(EType.valueOf(journalEditDto.getType().toUpperCase(Locale.ROOT)));
        this.journalDao.updateJournal(journal);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Journal> getAllJournal() {
        return this.journalDao.getAllJournal();
    }


}
