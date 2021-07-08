package com.gazete_dergi_otomasyon.controller;


import com.gazete_dergi_otomasyon.dto.JournalEditDto;
import com.gazete_dergi_otomasyon.dto.UploadJournalDto;
import com.gazete_dergi_otomasyon.model.*;
import com.gazete_dergi_otomasyon.service.IFileOperationService;
import com.gazete_dergi_otomasyon.service.IJournalService;
import com.gazete_dergi_otomasyon.service.JournalUploadFacade;
import org.hibernate.exception.ConstraintViolationException;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Controller
public class JournalController {

    @Autowired
    private IJournalService journalService;

    @Autowired
    private JournalUploadFacade journalUploadFacade;

    @Autowired
    private IFileOperationService fileOperationService;


    public String addJournal(UploadJournalDto uploadJournalDto){
        this.journalUploadFacade.addJournal(uploadJournalDto);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Yayın başarılı bir şekilde eklendi!", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        resetInputText(uploadJournalDto);
            return "";
    }

    public List<Journal> getAllJournal(){
        return this.journalService.getAllJournal();
    }

    public void updateJournal(JournalEditDto journalEditDto, Journal journal){
        if(journalEditDto.getTitle() == ""){
            journalEditDto.setTitle(journal.getTitle());
        }
        if(journalEditDto.getIssueNumber() == ""){
            journalEditDto.setIssueNumber(journal.getIssueNumber());
        }
        if(journalEditDto.getDate() == null){
            journalEditDto.setDate(journal.getDate());
        }
        if(journalEditDto.getType() == ""){
            journalEditDto.setType(journal.getType().label);
        }
        this.journalService.updateJournal(journal, journalEditDto);
        resetUpdateJournalDto(journalEditDto);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Yayın başarılı bir şekilde güncellendi!", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void removeJournal(Journal journal){
        this.journalService.removeJournal(journal);
    }


    public void uploadJournal(UploadedFile uploadedFile, String issueNum){
        try{
            this.fileOperationService.uploadFile(uploadedFile, issueNum);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Dosya başarılı bir şekilde yüklendi", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        catch (FileNotFoundException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Dosya Bulunamadı!", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);}

        catch (IOException e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Dosya yüklemede hata oldu. Lütfen uygun dosya girişi yapınız!", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }catch (ConstraintViolationException ex){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Dosya adını değiştirin!", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public void showFile(String fileName){
        this.fileOperationService.onRowSelect(fileName);
    }

    public StreamedContent getStreamedContent(){
        return this.fileOperationService.getStreamedContent();
    }


    public void setStreamedContent(StreamedContent streamedContent){
         this.fileOperationService.setStreamedContent(streamedContent);
    }



    private void  resetInputText(UploadJournalDto uploadJournalDto){
        uploadJournalDto.setTitle(null);
        uploadJournalDto.setFileName(null);
        uploadJournalDto.setDate(null);
        uploadJournalDto.setGenre(null);
        uploadJournalDto.setFile(null);
        uploadJournalDto.setPublisher(null);
        uploadJournalDto.setIssueNumber(null);
        uploadJournalDto.setType(null);
        uploadJournalDto.setNewGenre(null);
        uploadJournalDto.setNewPublisher(null);

    }

    private void resetUpdateJournalDto(JournalEditDto journalEditDto){
        journalEditDto.setDate(null);
        journalEditDto.setGenre(null);
        journalEditDto.setPublisher(null);
        journalEditDto.setIssueNumber(null);
        journalEditDto.setTitle(null);
        journalEditDto.setType(null);
    }
}
