package com.gazete_dergi_otomasyon.controller;


import com.gazete_dergi_otomasyon.dto.UploadJournalDto;
import com.gazete_dergi_otomasyon.model.*;
import com.gazete_dergi_otomasyon.service.IAdminService;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.*;

@Controller
public class AdminController {

    @Autowired
    private IAdminService adminService;

    public AdminController() {
    }

    public IAdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(IAdminService adminService) {
        this.adminService = adminService;
    }

    public void addJournal(UploadJournalDto uploadJournalDto){
        Publisher publisher = new Publisher(EPublisher.valueOf(uploadJournalDto.getPublisher()));
        Genre genre = new Genre(EGenre.valueOf(uploadJournalDto.getGenre()));
        Journal journal = new Journal(EType.valueOf(uploadJournalDto.getType()), uploadJournalDto.getTitle(), uploadJournalDto.getDate(),uploadJournalDto.getName(), publisher, genre, uploadJournalDto.getIssueNumber());
        this.adminService.addJournal(journal);
    }

    public void upload(FileUploadEvent event) {
        System.out.println("derya girdi");
        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputStream());

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public void copyFile(String fileName, InputStream in) {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

        try {
            System.out.println("deryaaa");
// write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(new File("C:/Users/Derya/Documents/GitHub/gazete-dergilik-otomasyon-sistemi/gazete-dergi-otomasyon/src/main/webapp/file" + fileName));

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            out.flush();
            out.close();

            System.out.println("New file created!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



}
