package com.gazete_dergi_otomasyon.service;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import java.io.*;

@Service
@PropertySource("classpath:application.properties")
public class FileOperationService implements IFileOperationService {

    @Value("${fileUpload.path}" )
    private String filePath;

    @Value("${fileDelete.path}" )
    private String fileDeletePath;


    public void uploadFile(UploadedFile uploadedFile, String issueNum) throws IOException {
        byte[] bytes = null;
        if (null != uploadedFile) {
                bytes = uploadedFile.getContent();
                String filename = FilenameUtils.getName(issueNum+"_"+uploadedFile.getFileName());
                BufferedOutputStream stream = null;
                stream = new BufferedOutputStream(new FileOutputStream(filePath + filename));
                stream.write(bytes);
                stream.close();
        }
    }

    @Override
    public void removeFile(String path) {
        File file = new File(this.fileDeletePath+ path);
        file.delete();
    }


}
