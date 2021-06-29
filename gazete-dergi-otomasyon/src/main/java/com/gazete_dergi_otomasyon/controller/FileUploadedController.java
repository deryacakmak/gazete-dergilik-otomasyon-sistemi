package com.gazete_dergi_otomasyon.controller;

import java.io.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.gazete_dergi_otomasyon.dto.UploadJournalDto;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.model.file.UploadedFile;
import org.springframework.stereotype.Controller;

@Controller
public class FileUploadedController {

    public String upload(UploadJournalDto uploadJournalDto) {

        UploadedFile uploadedFile = uploadJournalDto.getFile();
        String filePath = "C:/Users/Derya/Documents/GitHub/gazete-dergilik-otomasyon-sistemi/gazete-dergi-otomasyon/src/main/webapp/file";
        byte[] bytes = null;

        if (null != uploadedFile) {

            try {
                bytes = uploadedFile.getContent();
                String filename = FilenameUtils.getName(uploadedFile.getFileName());
                BufferedOutputStream stream = null;
                stream = new BufferedOutputStream(new FileOutputStream(new File(filePath + filename)));
                stream.write(bytes);
                stream.close();
                uploadJournalDto.setName(filename);
            } catch (NullPointerException ex) {
                System.out.println("null ");
            } catch (FileNotFoundException e) {
                System.out.println("file not found");
            } catch (IOException e) {
                System.out.println("io");
            }


        }

        else{
            System.out.println("null");
        }

        return "";
    }
}