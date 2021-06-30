package com.gazete_dergi_otomasyon.controller;

import java.io.*;

import com.gazete_dergi_otomasyon.dto.UploadJournalDto;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.model.file.UploadedFile;
import org.springframework.stereotype.Controller;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@Controller
public class FileUploadedController {

    public void upload(UploadJournalDto uploadJournalDto) {
        UploadedFile uploadedFile = uploadJournalDto.getFile();
        String filePath = "C:/Users/Derya/Documents/GitHub/gazete-dergilik-otomasyon-sistemi/gazete-dergi-otomasyon/src/main/webapp/file";
        byte[] bytes = null;

        if (null != uploadedFile) {
            try {
                bytes = uploadedFile.getContent();
                String filename = FilenameUtils.getName(uploadedFile.getFileName());
                uploadJournalDto.setName(filename);
                BufferedOutputStream stream = null;
                stream = new BufferedOutputStream(new FileOutputStream(new File(filePath + filename)));
                stream.write(bytes);
                stream.close();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Dosya başarılı bir şekilde yüklendi", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (FileNotFoundException e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Dosya Bulunamadı!", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);

            } catch (IOException e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Dosya yüklemede hata oldu. Lütfen uygun dosya girişi yapınız!", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);

            }
        }
    }
}