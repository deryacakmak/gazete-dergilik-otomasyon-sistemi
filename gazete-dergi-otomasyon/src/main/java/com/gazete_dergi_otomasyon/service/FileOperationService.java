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
    private StreamedContent streamedContent;
    private String selectedFileName;


    public FileOperationService() { }

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

    public void onRowSelect(String fileName) {
        selectedFileName = fileName;
        createStream(fileName);
    }

    private StreamedContent createStream(String fileName) {
        streamedContent = new DefaultStreamedContent(getData(fileName), "application/pdf", "downloaded_" + fileName);
        return streamedContent;
    }

    private InputStream getData(String fileName) {
        File file = new File( fileName);
        InputStream is = null;
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return is;
    }

    public StreamedContent getStreamedContent() {
        return streamedContent;
    }

    public void setStreamedContent(StreamedContent streamedContent) {
        this.streamedContent = streamedContent;
    }

    public void refreshStream() {
        createStream(selectedFileName);
    }

    public String generateRandomIdForNotCaching() {
        return java.util.UUID.randomUUID().toString();
    }



}
